package com.example.randomuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.Repository.RandomUserRepository
import com.example.randomuser.model.Results
import com.example.randomuser.model.Root
import com.example.randomuser.model.api.ApiState
import kotlinx.coroutines.launch

//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
class UserViewModel(val repository: RandomUserRepository = RandomUserRepository()) : ViewModel() {

    private val _dataState = MutableLiveData<ApiState<Root>>()
    val dataState: LiveData<ApiState<Root>> = _dataState

    init {
        fetchData()
    }

    private fun fetchData() {
        _dataState.postValue(ApiState.Loading)
        viewModelScope.launch {
            try {
                val response = repository.getUser() // Replace with your actual Retrofit call
                _dataState.postValue(response)
            } catch (e: Exception) {
                _dataState.postValue(ApiState.Error(e))
            }
        }
    }

}