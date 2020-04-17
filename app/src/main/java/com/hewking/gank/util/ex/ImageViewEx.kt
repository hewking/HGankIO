package com.hewking.gank.util.ex

import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgUrl: String) {
    Glide.with(context)
            .load(imgUrl)
            .into(this)
}