package com.sbardyuk.ttexercise.ttexercise.ui.main

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Picasso.with(imageView.context).load(url).into(imageView)
}