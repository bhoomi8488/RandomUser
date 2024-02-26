package com.example.randomuser.model.api

import com.example.randomuser.model.Root
import com.example.randomuser.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
class RandomUserWebServices {

    private var api : RandomUserApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(RandomUserApi::class.java)
    }
    suspend fun getUser(): Root{
        println("AAA--"+api.getUser())
        return api.getUser()
    }

    interface RandomUserApi{
        @GET("?results=10")
        suspend fun getUser(): Root
    }
}