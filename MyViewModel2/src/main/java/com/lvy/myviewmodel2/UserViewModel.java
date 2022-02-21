package com.lvy.myviewmodel2;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.lvy.myviewmodel2.room.User;

/**
 * Viewmodel  监听内容
 */
public class UserViewModel  extends  BaseObservable {

    private ObservableField<User>  userObservableField= new ObservableField();
    static  String TAGS="UserViewModel";

    public  UserViewModel(){
//          User user=new User("Nick","");
//        userObservableField.set(user);
    }


    @Bindable
    public String getUserName(){//监听
        return userObservableField.get().Username;
    }

    public void serUserName(String username){
        userObservableField.get().Username=username;
        Log.d(TAGS,"-----------"+userObservableField.get().Username);
    }

}
