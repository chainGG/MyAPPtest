package com.lvy.mypaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lvy.mypaging.Model.MyData;
import com.lvy.mypaging.Model.MyDatas;
import com.lvy.mypaging.Model.MyDatasArr;
//加载适配器
public class HomeAdapter  extends PagedListAdapter<MyDatasArr,HomeAdapter.HomeViewHolder> {

    private   Context mContext;
    //差分   只更新需要更细的
    private  static DiffUtil.ItemCallback< MyDatasArr> DIFF_CAlLLBACK = new DiffUtil.ItemCallback<MyDatasArr>() {
        @Override
        public boolean areItemsTheSame( MyDatasArr oldItem,  MyDatasArr newItem) {
            return oldItem== newItem;
        }

         @Override
        public boolean areContentsTheSame( MyDatasArr oldItem,  MyDatasArr newItem) {
            return    false;  // oldItem.equals( newItem) ;
        }

    };

    protected HomeAdapter(Context mContext) {
        super(DIFF_CAlLLBACK);
        this.mContext=mContext;
    }

    protected HomeAdapter( AsyncDifferConfig<MyDatasArr> config) {
        super(config);
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View ROOT=  LayoutInflater.from(mContext).inflate(R.layout.item_article_two_new,parent,false);

        return new HomeViewHolder(ROOT);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {
//        MyDatasArr arr=
        Log.e("TAG","----------"+getItem(position));
//        holder.tv_post_excerpt .setText(arr.post_excerpt);
//        holder.tvRecOneContent .setText(arr.post_title);


    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private  TextView tvRecOneContent;
        private   ImageView imgCover;
        private   TextView tv_post_excerpt;

        public HomeViewHolder(View itemView) {
            super(itemView);
           this.imgCover= itemView.findViewById(R.id.imgCover);
            this.tvRecOneContent= itemView.findViewById(R.id.tvRecOneContent);
            this.tv_post_excerpt= itemView.findViewById(R.id.tv_post_excerpt);


        }
    }
}
