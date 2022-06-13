package com.example.getretrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientProduct {

    private static RetrofitClientProduct instance = null;
    private ProductApi myApi;

    private RetrofitClientProduct() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ProductApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ProductApi.class);
    }

    public static synchronized RetrofitClientProduct getInstance() {
        if (instance == null) {
            instance = new RetrofitClientProduct();
        }
        return instance;
    }

    public ProductApi getMyApi() {
        return myApi;
    }



}
