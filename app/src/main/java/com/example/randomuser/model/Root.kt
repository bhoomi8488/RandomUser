package com.example.randomuser.model

import com.google.gson.annotations.SerializedName

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//

data class Root (

    @SerializedName("gender") val gender : String,
    @SerializedName("name") val name : Name,
    @SerializedName("location") val location : Location,
    @SerializedName("email") val email : String,
    @SerializedName("login") val login : Login,
    @SerializedName("dob") val dob : Dob,
    @SerializedName("registered") val registered : Registered,
    @SerializedName("phone") val phone : String,
    @SerializedName("cell") val cell : String,
    @SerializedName("id") val id : Id,
    @SerializedName("picture") val picture : Picture,
    @SerializedName("nat") val nat : String
)