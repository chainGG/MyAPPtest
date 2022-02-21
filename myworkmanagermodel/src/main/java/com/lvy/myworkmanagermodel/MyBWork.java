package com.lvy.myworkmanagermodel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyBWork extends Worker {
    public MyBWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
//        SystemClock.sleep(2000);
        Log.e("TAG","-----------执行DoWork:B");

        return Result.success();
    }
}
