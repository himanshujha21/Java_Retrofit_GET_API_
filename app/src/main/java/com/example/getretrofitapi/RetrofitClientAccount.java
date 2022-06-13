package com.example.getretrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit instance - This Java class is used to send requests to an API.

//This Java class is used to send requests to an API.
// We specify the URL that contains the data required and use the Retrofit Builder class.
public class RetrofitClientAccount {


    private static RetrofitClientAccount instance = null;
    private AccountApi myApi;

    private RetrofitClientAccount() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AccountApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(AccountApi.class);
    }

    public static synchronized RetrofitClientAccount getInstance() {
        if (instance == null) {
            instance = new RetrofitClientAccount();
        }
        return instance;
    }

    public AccountApi getMyApi() {
        return myApi;
    }
}

