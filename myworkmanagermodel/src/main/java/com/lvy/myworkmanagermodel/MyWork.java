package com.lvy.myworkmanagermodel;

import android.content.Context;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {
    public MyWork(Context context,  WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
//        SystemClock.sleep(2000);
        String inputData= getInputData().getString("input_data");
        Log.e("TAG","-----------执行DoWork:"+ inputData);
      Data data=  new Data.Builder()
                .putString("output_data", "jackS")
                .build();
        return Result.success(data);
    }
}
