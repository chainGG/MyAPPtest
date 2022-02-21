package com.lvy.myworkmanagermodel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyEWork extends Worker {
    public MyEWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("TAG","-----------执行DoWork:E");

        return Result.success();
    }
}
