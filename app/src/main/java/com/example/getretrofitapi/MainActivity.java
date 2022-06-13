package com.example.getretrofitapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.getretrofitapi.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainBinding.recyclerView1.setLayoutManager(linearLayoutManager);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mainBinding.recyclerView2.setLayoutManager(layoutManager);

       getApiData();
        getApiData2();
    }

    private void getApiData() {
        mainBinding.progressBar.setVisibility(View.VISIBLE);
        Call <AccountData> call = RetrofitClientAccount.getInstance().getMyApi().getAccountData();

        call.enqueue(new Callback <AccountData>() {
            @Override
            public void onResponse(@NonNull Call <AccountData> call, @NonNull Response <AccountData> response) {
                if (response.isSuccessful()) {
                    mainBinding.progressBar.setVisibility(View.GONE);
                    List <AData> list;
                    if (response.body() != null) {
                        list = response.body().getData();
                        Log.e("list", String.valueOf(list));
                        mainBinding.recyclerView1.setAdapter(new AccountAdapter(list));
                    }


                }

            }

            @Override
            public void onFailure(@NonNull Call <AccountData> call, @NonNull Throwable t) {
                mainBinding.progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();

            }


        });


    }

    private void getApiData2() {
        mainBinding.progressBar.setVisibility(View.VISIBLE);
        Call <ProductData> call = RetrofitClientProduct.getInstance().getMyApi().getProductData();
        call.enqueue(new Callback <ProductData>() {
            @Override
            public void onResponse(@NonNull Call <ProductData> call, @NonNull Response <ProductData> response) {
                if (response.isSuccessful()) {
                    mainBinding.progressBar.setVisibility(View.GONE);
                    List <PData> list;
                    if (response.body() != null) {
                        list = response.body().getData();
                       Log.e("list", String.valueOf(list));
                       mainBinding.recyclerView2.setAdapter(new ProductAdapter(list));
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call <ProductData> call, @NonNull Throwable t) {
                mainBinding.progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();

            }
        });
    }




}