package com.lvy.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.lvy.myapplication.databinding.ActivityMainBinding;

/**
 *  主界面
 */
public class MainActivity extends AppCompatActivity {
    String picPath="https://cdn-app-icon.pgyer.com/c/c/9/a/1/cc9a14f7ab6efcf06f549d50481f5bd5?x-oss-process=image/resize,m_lfit,h_120,w_120/format,jpg";
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MyViewModel myViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        activityMainBinding.setMyviewmodel(myViewModel);
        activityMainBinding.setLifecycleOwner(this); //设置监听生命周期

        Idol idol=new Idol("打球","23");
        //降低耦合度
        activityMainBinding.setIdol(idol);
        activityMainBinding.setEventHandler(new EventHandlerListener(this));
        loadNetImage();
    }
    private  void loadNetImage(){
        activityMainBinding.setNewworkImage(picPath);
    }

}