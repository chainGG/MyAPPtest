package com.lvy.mypaging.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyData<T> {
    public int current_page;
    public String from;
    public String to;
    public String last_page;
    public int per_page;



    @SerializedName("data")
    public List<T>  mData;



}
