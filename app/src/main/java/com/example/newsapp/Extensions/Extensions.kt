package com.example.newsapp.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url:String?){
    if(url!=null) {
        Glide.with(this).load(url).into(this)
    }
}