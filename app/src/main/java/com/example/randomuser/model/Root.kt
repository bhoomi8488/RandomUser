package com.example.randomuser.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//

@Parcelize
data class Root(
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("info") var info: Info? = Info()
) : Parcelable

@Parcelize
data class Results(
    @SerializedName("gender") val gender: String,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String,
    @SerializedName("login") val login: Login,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("registered") val registered: Registered,
    @SerializedName("phone") val phone: String,
    @SerializedName("cell") val cell: String,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("nat") val nat: String
) : Parcelable

@Parcelize
data class Name(
    @SerializedName("title") var title: String? = null,
    @SerializedName("first") var first: String? = null,
    @SerializedName("last") var last: String? = null
) : Parcelable

@Parcelize
data class Location(
    @SerializedName("street") var street: Street? = Street(),
    @SerializedName("city") var city: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("postcode")  var postcode: @RawValue Any? = null ,
    @SerializedName("coordinates") var coordinates: Coordinates? = Coordinates(),
    @SerializedName("timezone") var timezone: Timezone? = Timezone()
) : Parcelable

@Parcelize
data class Picture(
    @SerializedName("large") var large: String? = null,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null
) : Parcelable

@Parcelize
data class Registered(
    @SerializedName("date") var date: String? = null,
    @SerializedName("age") var age: Int? = null
) : Parcelable

@Parcelize
data class Street(
    @SerializedName("number") var number: Int? = null,
    @SerializedName("name") var name: String? = null
) : Parcelable

@Parcelize
data class Coordinates(
    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null
) : Parcelable

@Parcelize
data class Dob(
    @SerializedName("date") var date: String? = null,
    @SerializedName("age") var age: Int? = null
) : Parcelable

@Parcelize
data class Id(
    @SerializedName("name") var name: String? = null,
    @SerializedName("value") var value: String? = null
) : Parcelable

@Parcelize
data class Login(
    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("salt") var salt: String? = null,
    @SerializedName("md5") var md5: String? = null,
    @SerializedName("sha1") var sha1: String? = null,
    @SerializedName("sha256") var sha256: String? = null
) : Parcelable

@Parcelize
data class Info(
    @SerializedName("seed") var seed: String? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("version") var version: String? = null
) : Parcelable

@Parcelize
data class Timezone(
    @SerializedName("offset") var offset: String? = null,
    @SerializedName("description") var description: String? = null
) : Parcelable

