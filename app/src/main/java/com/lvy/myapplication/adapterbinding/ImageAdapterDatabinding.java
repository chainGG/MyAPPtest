package com.lvy.myapplication.adapterbinding;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.lvy.myapplication.R;
import com.squareup.picasso.Picasso;

/**
 *
 */
public class ImageAdapterDatabinding {
    @BindingAdapter("image")
    public  static  void setImage(ImageView image,String url){
        if (!TextUtils.isEmpty(url)){
            Picasso.get().load(url).placeholder(R.mipmap.ic_launcher_round).into(image);
        }else{
            image.setBackgroundColor(Color.BLUE);
        }
    }

}
