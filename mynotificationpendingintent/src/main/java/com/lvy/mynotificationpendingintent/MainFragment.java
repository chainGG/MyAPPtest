package com.lvy.mynotificationpendingintent;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 *
 */
public class MainFragment extends Fragment {

    private int notificationId=0;
    private String channelId="";
    private NotificationManager notificationManager;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn=getView().findViewById(R.id.button);
        notificationManager = getActivity().getSystemService(NotificationManager.class);

        btn.setOnClickListener(v -> {
//            NavController navController= Navigation.findNavController(v);
//            navController.navigate(R.id.action_mainFragment_to_detailFragment);

            sendNotification();
        });
    }

    public void sendNotification(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(getActivity().getPackageName(),"channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("1111111");
            channel.enableLights(true); //是否在桌面icon右上角展示小红点
            channel.setLightColor(Color.GREEN); //小红点颜色
            channel.setShowBadge(true); //是否在久按桌面图标时显示此渠道的通知
            notificationManager.createNotificationChannel(channel);
        }

        Notification notification= new NotificationCompat.Builder(getContext(),channelId)
                .setContentTitle("测试pending")
                .setContentText("测试pending")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(setPendingIntent())
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .build();



//        NotificationManagerCompat notificationCompat= NotificationManagerCompat.from(getActivity());

//        notificationManager.notify(notificationId++,notification);

//        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//            @SuppressLint("WrongConstant")
//            NotificationChannel notificationChannel = new NotificationChannel("ID", "NAME", importance);
//            notificationChannel.enableVibration(true);
//            notificationChannel.setShowBadge(true);
//            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
//
//            if (notificationManager != null) {
//                notificationManager.createNotificationChannel(notificationChannel);
//            }
//        }
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getContext(), "ID");
//        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
//        mBuilder.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
//        mBuilder.setDefaults(Notification.DEFAULT_ALL);
//        mBuilder.setAutoCancel(true);
//        mBuilder.setContentTitle("title");
//        mBuilder.setContentText("content");
//        mBuilder.setContentIntent(setPendingIntent());
//        mBuilder.setNumber(1);
//        final Notification notify = mBuilder.build();
//
//        //随机id 1000-2000
        final int notifyId = (int) (Math.random() * 1000 + 1000);
        if (notificationManager != null) {
            notificationManager.notify(notifyId, notification);
        }
//        Log.e("TAG","-----------------"+checkNotifySetting(getContext()));
    }

    private PendingIntent setPendingIntent() {
        Bundle  args=new Bundle();
        args.putString("names","jacks");
        return Navigation.findNavController(getActivity(),R.id.button)
                .createDeepLink()
                .setGraph(R.navigation.nav_my_graph)
                .setDestination(R.id.detailFragment)
                .setArguments(args)
                .createPendingIntent();
        //建立深层链接
    }

    public static boolean checkNotifySetting(Context context) {

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);

// areNotificationsEnabled方法的有效性官方只最低支持到API 19，低于19的仍可调用此方法不过只会返回true，即默认为用户已经开启了通知。

        return manager.areNotificationsEnabled();

    }
}