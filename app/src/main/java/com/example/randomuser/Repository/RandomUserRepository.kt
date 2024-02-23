package com.example.randomuser.Repository

import com.example.randomuser.model.Root
import com.example.randomuser.model.api.ApiState
import com.example.randomuser.model.api.RandomUserWebServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
class RandomUserRepository(private val countriesWebServices: RandomUserWebServices = RandomUserWebServices()) {
    fun getUser(): Flow<ApiState<List<Root>>> = flow {
        try {
            val response = countriesWebServices.getCountries()
            emit(ApiState.Success(response))
        } catch (e: Exception) {
            emit(ApiState.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}