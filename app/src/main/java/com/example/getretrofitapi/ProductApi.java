package com.example.getretrofitapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {


    //https://stag.insee.com/mds/products/admin/getAllProductMasterList

    String BASE_URL = "https://stag.insee.com/mds/products/admin/";

    @GET("getAllProductMasterList")
    Call <ProductData> getProductData();

}
