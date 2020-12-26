package com.hewking.gank.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgUrl: String) {
    Glide.with(context)
            .load(imgUrl)
            .into(this)
}