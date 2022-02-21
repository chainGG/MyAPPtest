package com.lvy.myworkmanagermodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SecendActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend2);
    }

    public void chainWork(View view) {

        OneTimeWorkRequest  workRequestA= new OneTimeWorkRequest.Builder(MyAWork.class).build();
        OneTimeWorkRequest  workRequestB= new OneTimeWorkRequest.Builder(MyBWork.class).build();
        OneTimeWorkRequest  workRequestC= new OneTimeWorkRequest.Builder(MyCWork.class).build();
        OneTimeWorkRequest  workRequestD= new OneTimeWorkRequest.Builder(MyDWork.class).build();

        OneTimeWorkRequest  workRequestF= new OneTimeWorkRequest.Builder(MyBWork.class).build();
        OneTimeWorkRequest  workRequestG= new OneTimeWorkRequest.Builder(MyDWork.class).build();


        OneTimeWorkRequest  workRequestE= new OneTimeWorkRequest.Builder(MyEWork.class).build();

        //链式任务 列表
        WorkContinuation workContinuation1 = WorkManager.getInstance(this)
                .beginWith(workRequestA)
                .then(workRequestB);
        WorkContinuation workContinuation2 = WorkManager.getInstance(this)
                .beginWith(workRequestC)
                .then(workRequestD);

        


        ArrayList<WorkContinuation> mlist=new ArrayList<>();
        mlist.add(workContinuation1);
        mlist.add(workContinuation2);

        //进行组合后再执行
        WorkContinuation.combine(mlist)
                .then(workRequestE)
                .enqueue();



    }
}