package com.lvy.myroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.lvy.myroom.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String picPath="https://cdn-app-icon.pgyer.com/c/c/9/a/1/cc9a14f7ab6efcf06f549d50481f5bd5?x-oss-process=image/resize,m_lfit,h_120,w_120/format,jpg";
    List<User> data=new ArrayList<>();
    MyDao mydao;
    private MyRecylerViewAdapter adapter;
    private ActivityMainBinding mainBinding;
    private MyRoomViewModel myRoomViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);// setContentView();

        adapter= new MyRecylerViewAdapter(data);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setAdapter(adapter);
        myRoomViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyRoomViewModel.class);
        myRoomViewModel.getAllUserData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setData(users);
            }
        });
    }

    private ArrayList<User> mData=new ArrayList<>();

    public void mInsert(View view) {
        User u1= new User("Toms","23");
        myRoomViewModel.mInsert(u1);
     }
    public void mDetele(View view) {
        User u1= new User(3,"Toms","23");
        myRoomViewModel.mDetele(u1);

    }
    public void mUpData(View view) {
        User u1= new User(3,"JA","11");
        myRoomViewModel.mUpData(u1);
     }
    public void mDeleteAllUser(View view) {
        myRoomViewModel.mDeteleAllData();
    }

}