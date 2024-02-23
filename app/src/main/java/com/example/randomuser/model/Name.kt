package com.example.randomuser.model

import com.google.gson.annotations.SerializedName

//
// Created by bhoomi on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
data class Name (

    @SerializedName("title" ) var title : String? = null,
    @SerializedName("first" ) var first : String? = null,
    @SerializedName("last"  ) var last  : String? = null

)