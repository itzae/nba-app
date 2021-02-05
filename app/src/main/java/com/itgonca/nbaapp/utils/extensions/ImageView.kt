package com.itgonca.nbaapp.utils.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(path:String){
    Glide.with(this)
        .load(path)
        .into(this)
}