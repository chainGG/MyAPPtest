package com.lvy.myviewmodel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;

import com.lvy.myviewmodel2.databinding.ActivityMainBinding;
import com.lvy.myviewmodel2.room.User;

/**
 * 双向绑定    输入项   监听文本    通过第三方内容进行绑定异常   只能单向绑定
 */
public class MainActivity extends AppCompatActivity {
    String picPath="https://cdn-app-icon.pgyer.com/c/c/9/a/1/cc9a14f7ab6efcf06f549d50481f5bd5?x-oss-process=image/resize,m_lfit,h_120,w_120/format,jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding= DataBindingUtil .setContentView(this,R.layout.activity_main);// setContentView();
        User User=new User( 1,"java",picPath);
//        User.username.set("java");
        UserViewModel  userViewModel= new UserViewModel();//布局文件传viewmodel
        mainBinding.setUserViewModel(userViewModel);

        ObservableField<String> userNAMES=new ObservableField<>("User");
        mainBinding.setUser(userNAMES);//如果进行了修改的
    }
}