package com.example.randomuser.Repository

import com.example.randomuser.model.Root
import com.example.randomuser.model.api.ApiState
import com.example.randomuser.model.api.RandomUserWebServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

//
// Created by bhoomi on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
class RandomUserRepository(private val userWebServices: RandomUserWebServices = RandomUserWebServices()) {
    suspend fun getUser(): ApiState<Root> {
        return try {
            val response = userWebServices.getUser()
            ApiState.Success(response)
        } catch (e: Exception) {
            println("AAA--e--"+e.message)
            ApiState.Error(e)
        }
    }
}