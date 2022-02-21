package com.lvy.mypaging.api;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyAPI {

    public static String   baseUrl = "https://qt.fankomedical.com/api/";

    @GET("homepage")
    Call<MyDatas<MyData>> getData(@Query("page")int page);

}
