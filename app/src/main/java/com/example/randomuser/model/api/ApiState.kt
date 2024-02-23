package com.example.randomuser.model.api

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
sealed class ApiState<out  T> {
    data object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val exception: Exception) : ApiState<Nothing>()
}

