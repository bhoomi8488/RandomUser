package com.example.randomuser.adpater

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.randomuser.model.Results

//
// Created by bhoomi on 2/1/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
@BindingAdapter("combinedText")
fun TextView.setCombinedText(data : Results) {
    text = buildString {
        append(data.name.title)
        append(". ")
        append(data.name.first)
        append(" ")
        append(data.name.last)
    }
}

@BindingAdapter("addressText")
fun TextView.setAddressText(data : Results) {
    text = buildString {
        append(data.location.street?.number)
        append(", ")
        append(data.location.street?.name)
        append(", ")
        append("\n")
        append(data.location.city)
        append(", ")
        append(data.location.state)
        append(", ")
        append("\n")
        append(data.location.country)
        append(", ")
        append(data.location.postcode)
    }
}


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context)
            .load(it)
            .into(view)
    }
}