package com.lvy.myviewmodel2.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false) //Schema 版本升级
public abstract class MyDataBase extends RoomDatabase {
   private  static MyDataBase  myDataBase;
   static String  database_Name="myDataBase.db";
    public    static  synchronized  MyDataBase getInstance(Context context){
            if (myDataBase==null){
                myDataBase = Room.databaseBuilder(context.getApplicationContext(),
                        MyDataBase.class,
                        database_Name).build();
            }
        return  myDataBase;
    }

    public abstract MyDao getUser();
}
