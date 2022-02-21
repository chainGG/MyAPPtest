package com.lvy.mypaging.paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;

public class HomeDataSourceFactory extends DataSource.Factory<Integer, MyDatas<MyData>> {


    @Override
    public DataSource<Integer, MyDatas<MyData>> create() {
        return new HomePositionalDataSource();
    }
}
