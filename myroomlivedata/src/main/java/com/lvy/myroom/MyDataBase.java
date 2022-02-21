package com.lvy.myroom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import org.jetbrains.annotations.NotNull;

/**
 *   升级      修改字段类型
 */
@Database(entities = {User.class},version = 5,exportSchema = true) //Schema 版本升级
public abstract class MyDataBase extends RoomDatabase {
   private  static MyDataBase  myDataBase;
   static String  database_Name="myDataBase.db";
    public    static  synchronized  MyDataBase getInstance(Context context){
            if (myDataBase==null){
                myDataBase = Room.databaseBuilder(context.getApplicationContext(),
                        MyDataBase.class,
                        database_Name)
                        .addMigrations(baseVersion1_2,baseVersion2_3,baseVersion4_5)
//                        // 处理升级的时候没有对应Migration 异常  表数据会清空 重建数据库表
//                         //还处理版本回退
                        .fallbackToDestructiveMigration() //
                        .build();
            }
        return  myDataBase;
    }
    //数据库升级
    static  final Migration baseVersion1_2  =new Migration(1,2) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            // 升级后  添加一列
            database.execSQL("ALTER TABLE  User ADD COLUMN sex INTEGER NOT NULL DEFAULT 0");
        }
    };
    //数据库升级
    static  final Migration baseVersion2_3  =new Migration(2,3) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
            // 升级后  添加一列
//            database.execSQL("ALTER TABLE  User ADD COLUMN sex INTEGER NOT NULL DEFAULT 0");
        }
    };
    //数据库升级
    static  final Migration baseVersion4_5 =new Migration(4,5) {
        @Override
        public void migrate(@NonNull @NotNull SupportSQLiteDatabase database) {
             //创建临时表     数据导入    删除表   修改表名
            database.execSQL("CREATE TABLE  Temp_User(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "Username TEXT," +
                    "Age TEXT,"+
                    "sex TEXT   DEFAULT 'm')");
            database.execSQL("INSERT INTO  Temp_User (Username,age ,sex) "+
                    "SELECT Username,age ,sex FROM User"
                    );  //导入表
            database.execSQL("DROP TABLE User");
            database.execSQL("ALTER TABLE Temp_User RENAME TO User");

        }
    };
    public abstract MyDao getUser();
}
