package com.lvy.mypaging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;
import com.lvy.mypaging.api.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDataSource extends PageKeyedDataSource< Integer, MyDatas<MyData>> {

    public  static  int PER_PAGE= 10;
    public int FIRST_PAGE=1;

    //初始加载
    @Override
    public void loadInitial(  LoadInitialParams<Integer> params,  LoadInitialCallback<Integer, MyDatas<MyData>> callback) {

         RetrofitClient.getInstance()
                .getAPI()
                .getData(FIRST_PAGE)
                .enqueue(new Callback<MyDatas<MyData>>() {
                    @Override
                    public void onResponse(Call<MyDatas<MyData>> call, Response<MyDatas<MyData>> response) {
                        if (response.body()!=null){
                            Log.e("loadInitial","----------------loadInitial"+response.body().data.current_page+"------------"+response.body().data.per_page+"--------------"+response.body().data.mData.size());
//                            callback.onResult(response.body().data.mData
//                                    ,response.body().data.current_page
//                                    ,response.body().data.per_page+1);
                            callback.onResult(response.body().data.mData,null,FIRST_PAGE+1);

                        }
                    }
                    @Override
                    public void onFailure(Call<MyDatas<MyData>> call, Throwable t) {

                    }
                });
        ;
    }

    //加载之后
    @Override
    public void loadAfter(@NonNull @NotNull LoadParams<Integer> params, @NonNull @NotNull LoadCallback<Integer, MyDatas<MyData>> callback) {
        RetrofitClient.getInstance()
                .getAPI()
                .getData(FIRST_PAGE)
                .enqueue(new Callback<MyDatas<MyData>>() {
                    @Override
                    public void onResponse(Call<MyDatas<MyData>> call, Response<MyDatas<MyData>> response) {
                        if (response.body()!=null){
                           Integer nextKey= response.body().hasMore?params.key+1 :null;
                          callback.onResult(response.body().data.mData,nextKey);

                        }
                    }
                    @Override
                    public void onFailure(Call<MyDatas<MyData>> call, Throwable t) {

                    }
                });
    }

    //加载前
    @Override
    public void loadBefore(@NonNull @NotNull LoadParams<Integer> params, @NonNull @NotNull LoadCallback<Integer, MyDatas<MyData>> callback) {

    }
}
