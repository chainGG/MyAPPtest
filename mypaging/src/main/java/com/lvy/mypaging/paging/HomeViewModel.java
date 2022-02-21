package com.lvy.mypaging.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;
import com.lvy.mypaging.Model.MyDatasArr;

public class HomeViewModel extends ViewModel {

    public LiveData<PagedList< MyDatasArr>>  homeDataList;

    public HomeViewModel( ) {
        //加载下一页
        PagedList.Config config=new PagedList.Config.Builder()
                //设置空间占位
                .setEnablePlaceholders(false)
                .setPageSize(HomePositionalDataSource.PER_PAGE)
                //设置当距离底部还有多少条数据的时候加载下一页
                .setPrefetchDistance(2)
                //设置初始加载的数量
                .setInitialLoadSizeHint(HomePositionalDataSource.PER_PAGE*2)
                //最大加载数量
                .setMaxSize(65536*HomePositionalDataSource.PER_PAGE)
                .build();

        this.homeDataList = new LivePagedListBuilder(new HomeDataSourceFactory(),config).build();
    }
}
