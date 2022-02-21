package com.lvy.myviewmodel2.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 *  我的数据库操作
 */
@Dao
public interface MyDao {
    @Insert
    void  InsertData(User... user);

    @Delete
    void  DeleteData(User... user);

    @Update
    void  UpdataData(User... user);

    @Query("SELECT * from USER")
    List<User> SelectData();


    @Query("SELECT * from USER WHERE id=:id")
    List<User> SelectData(String  id);
}
