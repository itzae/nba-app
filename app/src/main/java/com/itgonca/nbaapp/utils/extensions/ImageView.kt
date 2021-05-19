package com.itgonca.nbaapp.utils.extensions

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.itgonca.nbaapp.R

fun AppCompatImageView.loadImageUrl(path:String){
    Glide.with(this)
        .load(path)
        .error(R.drawable.nba)
        .into(this)
}