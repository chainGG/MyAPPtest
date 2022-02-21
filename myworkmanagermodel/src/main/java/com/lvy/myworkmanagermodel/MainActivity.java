package com.lvy.myworkmanagermodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddWork(View view) {
        //设置约束条件   比如网络连接的时候   网络断开
        Constraints constraints = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            constraints = new Constraints.Builder()
                    //
//                    NetworkType.NOT_REQUIRED  //没有网络连接的需求
//                    NetworkType.CONNECTED  // 网络连接的时候执行
//                    NetworkType.UNMETERED  //不计费网络 wifi
//                    NetworkType.NOT_ROAMING  // 非漫游网络状态
//                    NetworkType.METERED  // 计费网络 开启
                    .setRequiredNetworkType(NetworkType.CONNECTED)// 网络连接 的时候
//                    .setRequiresBatteryNotLow(true)//指定设备电池是否不应低于临界阈值
//                    .setRequiresStorageNotLow(true) //在待机状态执行   指定设备可用存储是否不应低于临界阈值
//                    .setRequiresDeviceIdle(true)//指定{@link WorkRequest}运行时设备是否为空闲
//                    .setRequiresCharging(true)//指定要运行的{@link WorkRequest}是否应该插入设备   充电
    //                .addContentUriTrigger(myUri,false)//指定内容{@link android.net.Uri}时是否应该运行{@link WorkRequest}更新
                    .build();
        }

        //传递参数
        Data data =new Data.Builder()
                .putString("input_data","jack")
                .build();

        //一次性任务
        OneTimeWorkRequest workRequest= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            workRequest = new OneTimeWorkRequest.Builder(MyWork.class)
                    .setConstraints(constraints)   //设置约束
                    //设置延迟执行
                    .setInitialDelay(5, TimeUnit.SECONDS)
                    //指数退避策略   类似重试
                    .setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))//
                    //添加标签
                    .addTag("work1")
                    .setInputData(data)
                    .build();
        }else {
            workRequest = new OneTimeWorkRequest.Builder(MyWork.class)
                    .setConstraints(constraints)   //设置约束
                    //设置延迟执行
                    .setInitialDelay(5, TimeUnit.SECONDS)
                    //添加标签
                    .addTag("work1")
                    .setInputData(data)
                    .build();
        }
        //周期性任务     不能少于15分钟
        @SuppressLint({"NewApi", "LocalSuppress"}) PeriodicWorkRequest  workRequest2 = new PeriodicWorkRequest.Builder(MyWork.class,Duration.ofMinutes(15)).build();

        WorkManager workManager = WorkManager.getInstance(this);
        //执行任务
        workManager.enqueue(workRequest);

//        //观察任务状态
        workManager.getWorkInfoByIdLiveData(workRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.e("TAG","--------------"+workInfo.toString()+"--------------"+workInfo.getState());
                if (workInfo !=null&&workInfo.getState()== WorkInfo.State.SUCCEEDED) {
                    Log.e("TAG", "--------------" + workInfo.getOutputData().getString("output_data"));
                }
            }
        });

        //取消任务
//        OneTimeWorkRequest finalWorkRequest = workRequest;
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
////                workManager.cancelWorkById(finalWorkRequest.getId());
//            }
//        },2000);


    }
}