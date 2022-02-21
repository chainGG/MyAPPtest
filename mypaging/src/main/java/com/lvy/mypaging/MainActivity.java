package com.lvy.mypaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;
import com.lvy.mypaging.Model.MyDatasArr;
import com.lvy.mypaging.paging.HomeViewModel;

/**
 *   列表分页
 *   缓存 分页
 *   PositionalDataSource       数据源返回的数据格式 决定三种分页方式           正常  jsonobject{ jsonArray{ }}
 *   PageKeyedDataSource        格式  jsonobject{   jsonArray[]}
 *   ItemKeyedDataSourc             jsonArray[]
 */
public class MainActivity extends AppCompatActivity {
    RecyclerView mrecyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mrecyclerview=findViewById(R.id.mrecyclerview);

        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        HomeAdapter homeadapter=new HomeAdapter(this);
        mrecyclerview.setAdapter(homeadapter);

        HomeViewModel model =new  ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(HomeViewModel.class);
        model.homeDataList.observe(this, new Observer<PagedList< MyDatasArr>>() {
            @Override
            public void onChanged(PagedList< MyDatasArr> myDatas) {
                homeadapter.submitList(myDatas);
            }
        });

    }


//    @Override
//    protected void onUserLeaveHint() {
//        super.onUserLeaveHint();
//    }
//
//    @Override
//    public void onUserInteraction() {
//        super.onUserInteraction();
//    }
}