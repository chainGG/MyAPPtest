package com.lvy.mypaging.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient mclient;
    private static    String BaseUrl= "https://qt.fankomedical.com/api/";
    private static  Retrofit retrofit;
    public RetrofitClient() {

         retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                 .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder().build();
    }

    public  static  synchronized  RetrofitClient getInstance(){
        if (mclient==null){
            mclient =new RetrofitClient();
        }
        return mclient;
    }

    public  MyAPI getAPI(){
        return  retrofit.create(MyAPI.class);
    }
}
