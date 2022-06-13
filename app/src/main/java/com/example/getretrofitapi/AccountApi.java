package com.example.getretrofitapi;

import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Interface class- This Java class is used to define endpoints.

//Endpoints usually are defined inside an Interface class. An endpoint refers to the path where information is obtained.

//Next we will have a call<results> object that will return the information from the API.
public interface AccountApi {

    //https://stag.insee.com/mds/account/master

    String BASE_URL = "https://stag.insee.com/mds/";
   // String BASE_URL2 = "https://stag.insee.com/mds/products/admin/";


    @GET("account/master")
    Call <AccountData> getAccountData();


}

