package com.lvy.myroom;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

/***
 * 数据库炒作类
 */
public class  MyRoomRepository {


    //传入 数据库对象
     private MyDao myDao;

    public MyRoomRepository(Context context) {
        MyDataBase myDataBase= MyDataBase.getInstance(context);
        this.myDao = myDataBase.getUser();
    }


    public void mInsert(User... u1) {
        new TastInSert(myDao).execute(u1);
    }

    public void mDetele(User... u1) {
        new TastDetele(myDao).execute(u1);
    }

    public void mUpData(User... u1) {
        new TastUpdata(myDao).execute(u1);
    }

    public void mDeteleAllData() {
         new TastDeleteAllUser(myDao).execute();
    }
    public LiveData<List<User>> getAllUserData() {

        return myDao.SelectData();
    }

    class   TastInSert extends AsyncTask<User,Void,Void> {
        private MyDao mydao;
        public TastInSert(MyDao mydao) { this.mydao=mydao; }

        @Override
        protected Void doInBackground(User... users) {
            mydao.InsertData(users);
             return null;
        }
    }

    class   TastDetele extends AsyncTask<User,Void,Void>{
        private MyDao mydao;
        public TastDetele(MyDao mydao) {
            this.mydao=mydao;
        }
        @Override
        protected Void doInBackground(User... users) {
            mydao.DeleteData(users);

            return null;
        }
    }


    class   TastUpdata extends AsyncTask<User,Void,Void>{
        private MyDao mydao;
        public TastUpdata(MyDao mydao) {
            this.mydao=mydao;
        }
        @Override
        protected Void doInBackground(User... users) {
            mydao.UpdataData(users);
            return null;
        }
    }

    class   TastDeleteAllUser extends AsyncTask<Void,Void,Void>{
        private MyDao mydao;
        public TastDeleteAllUser(MyDao mydao) {
            this.mydao=mydao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mydao.DeleteAllData();

            return null;
        }
    }



}
