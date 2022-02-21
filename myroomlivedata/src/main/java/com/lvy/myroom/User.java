package com.lvy.myroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int  id;
    @ColumnInfo(name = "Username",typeAffinity = ColumnInfo.TEXT)
    public   String  Username;
    @ColumnInfo(name = "Age",typeAffinity = ColumnInfo.TEXT)
    public   String  Age;
    @ColumnInfo(name = "sex",typeAffinity = ColumnInfo.TEXT)
    public String  sex;



    public String getId() {
        return id+"";
    }

    public User(int id, String username, String age) {
        this.id = id;
        Username = username;
        Age = age;
    }
    //注释不必要创建的执行方法   建表
    @Ignore
    public User(String username, String age) {
        Username = username;
        Age = age;
    }
    //注释不必要创建的执行方法   建表
    @Ignore
    public User(int id) {
        this.id = id;
    }

    public User() {
    }
}
