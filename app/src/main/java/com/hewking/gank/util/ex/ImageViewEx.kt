package com.hewking.gank.util.ex

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgUrl: String) {
    Log.d("ImageViewEx","load:$imgUrl")
    Glide.with(context)
            .load(imgUrl)
            .into(this)
}