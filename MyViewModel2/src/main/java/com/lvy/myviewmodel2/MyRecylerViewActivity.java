package com.lvy.myviewmodel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import com.lvy.myviewmodel2.databinding.ActivityMyRecylerViewBinding;
import com.lvy.myviewmodel2.recylerview.MyRecylerViewAdapter;
import com.lvy.myviewmodel2.room.MyDao;
import com.lvy.myviewmodel2.room.MyDataBase;
import com.lvy.myviewmodel2.room.User;
import java.util.ArrayList;
import java.util.List;

/**
 *   databinding  列表绑定
 */
public class MyRecylerViewActivity extends AppCompatActivity {
    String picPath="https://cdn-app-icon.pgyer.com/c/c/9/a/1/cc9a14f7ab6efcf06f549d50481f5bd5?x-oss-process=image/resize,m_lfit,h_120,w_120/format,jpg";
    List<User> data=new ArrayList<>();
    MyDao mydao;
    private MyRecylerViewAdapter adapter;
    private ActivityMyRecylerViewBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_my_recyler_view);// setContentView();

        adapter= new MyRecylerViewAdapter(data);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerView.setAdapter(adapter);

        MyDataBase dataBase=MyDataBase.getInstance(this);
        mydao=dataBase.getUser();
    }

    private ArrayList<User> mData=new ArrayList<>();

    public void mInsert(View view) {
        User u1= new User("Toms","23");
        new TastInSert(mydao).execute(u1);
    }
    public void mDetele(View view) {
        User u1= new User(3,"Toms","23");
        new TastDetele(mydao).execute(u1);
    }
    public void mUpData(View view) {
        User u1= new User(3,"JA","11");
        new TastUpdata(mydao).execute(u1);
    }
    public void mQuery(View view) {
         new TastQuery(mydao).execute();
    }

    class   TastInSert extends AsyncTask<User,Void,Void>{
        private MyDao mydao;
        public TastInSert(MyDao mydao) {
            this.mydao=mydao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mydao.InsertData(users);
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

    class   TastQuery extends AsyncTask<User,Void,Void>{
        private MyDao mydao;
        public TastQuery(MyDao mydao) {
            this.mydao=mydao;
        }
        @Override
        protected Void doInBackground(User... users) {
            data=mydao.SelectData();

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            adapter= new MyRecylerViewAdapter(data);
            mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(MyRecylerViewActivity.this));
            mainBinding.recyclerView.setAdapter(adapter);
            super.onPostExecute(unused);
        }
    }


}