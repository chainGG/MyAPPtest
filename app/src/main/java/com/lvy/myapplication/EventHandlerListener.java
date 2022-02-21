package com.lvy.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class EventHandlerListener {
    Context context;
    public EventHandlerListener(Context context){
        this.context=context;
    }

    public void buttonOnClick(View view){
        view.setBackgroundResource(R.mipmap.ic_launcher_round);
        Toast.makeText(context,"点击事件",Toast.LENGTH_SHORT).show();
    }


}
