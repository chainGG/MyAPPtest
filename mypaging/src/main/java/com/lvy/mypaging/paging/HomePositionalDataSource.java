package com.lvy.mypaging.paging;

import android.util.Log;

import androidx.paging.PositionalDataSource;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;
import com.lvy.mypaging.Model.MyDatasArr;
import com.lvy.mypaging.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePositionalDataSource extends PositionalDataSource<MyDatas<MyData>> {
    public static  int  PER_PAGE=10;
    //首页加载数据调用
    @Override
    public void loadInitial( PositionalDataSource.LoadInitialParams params,  PositionalDataSource.LoadInitialCallback<MyDatas<MyData>> callback) {

        int startPosition=1;
        RetrofitClient.getInstance()
                .getAPI()
                .getData(startPosition)

                .enqueue(new Callback<MyDatas<MyData>>() {
                    @Override
                    public void onResponse(Call<MyDatas<MyData>>call, Response<MyDatas<MyData>> response) {
                        if (response.body()!=null){
                            Log.e("loadInitial","----------------loadInitial"+response.body().data.current_page+"------------"+response.body().data.per_page+"--------------"+response.body().data.mData.size());

                            callback.onResult(response.body().data.mData
                            ,response.body().data.current_page
                            ,response.body().data.per_page+1);

                        }
                    }
                    @Override
                    public void onFailure(Call<MyDatas<MyData>> call, Throwable t) {

                    }
                });
        ;
    }
    //加载下一页
    @Override
    public void loadRange( PositionalDataSource.LoadRangeParams params,  PositionalDataSource.LoadRangeCallback<MyDatas<MyData>> callback) {
        Log.e("loadRange","----------------loadRange");

        //加载下一页
        RetrofitClient.getInstance()
                .getAPI()
                .getData(params.startPosition)
                .enqueue(new Callback<MyDatas<MyData>>() {
                    @Override
                    public void onResponse(Call<MyDatas<MyData>> call, Response<MyDatas<MyData>> response) {
                        if (response.body()!=null){
                            callback.onResult(response.body().data.mData);
                            Log.e("loadRange","----------------loadRange"+response.body().data.mData);
                        }

                    }

                    @Override
                    public void onFailure(Call<MyDatas<MyData>> call, Throwable t) {
                    }
                });



    }
}
