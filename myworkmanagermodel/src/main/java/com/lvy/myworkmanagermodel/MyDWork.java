package com.lvy.myworkmanagermodel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyDWork extends Worker {
    public MyDWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("TAG","-----------执行DoWork:C");

        return Result.success();
    }
}
