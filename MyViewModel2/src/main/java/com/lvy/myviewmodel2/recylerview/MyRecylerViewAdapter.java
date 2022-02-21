package com.lvy.myviewmodel2.recylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lvy.myviewmodel2.R;
import com.lvy.myviewmodel2.databinding.ItemViewBinding;
import com.lvy.myviewmodel2.room.User;

import java.util.List;

public class MyRecylerViewAdapter  extends RecyclerView.Adapter<MyRecylerViewAdapter.MyViewHolder> {
    List<User> mData;
    public MyRecylerViewAdapter(List<User> mData) {
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       ItemViewBinding itemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_view,parent,false);

        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyRecylerViewAdapter.MyViewHolder holder, int position) {
        User mUser= mData.get(position);
        holder.itemBinding.setUser(mUser);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private  ItemViewBinding itemBinding;
        public MyViewHolder(View itemView) {
            super(itemView);
        }
        public MyViewHolder(ItemViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding =itemBinding;
        }
    }

}
