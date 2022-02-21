package com.lvy.myroom;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 */
public class MyRoomViewModel extends AndroidViewModel {
    //增删改查
    MyRoomRepository myRoomRepository;
    public MyRoomViewModel(@NonNull @NotNull Application application) {
        super(application);
        myRoomRepository=new MyRoomRepository(application);
    }

    public void mInsert(User... u1) {
        myRoomRepository.mInsert(u1);
    }

    public void mDetele(User... u1) {
        myRoomRepository.mDetele(u1);
    }

    public void mUpData(User... u1) {
        myRoomRepository.mUpData(u1);
    }

    public void mDeteleAllData( ) {
        myRoomRepository.mDeteleAllData();
    }

    public LiveData<List<User>> getAllUserData(){

        return  myRoomRepository.getAllUserData();
    }
}
