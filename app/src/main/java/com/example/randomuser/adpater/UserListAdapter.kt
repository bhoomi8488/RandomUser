package com.example.randomuser.adpater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.randomuser.R
import com.example.randomuser.databinding.UserListLayoutBinding
import com.example.randomuser.model.Results


//
// Created by bhoom on 2/23/2024.
// Copyright (c) 2024 Bhoomi. All rights reserved.
//
class UserListAdapter(private var users: List<Results>,private val onItemClick: (Results) -> Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
     class UserViewHolder(val binding: UserListLayoutBinding) :
         RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = users[position]
        holder.binding.userData = item

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    fun updateData(data: List<Results>) {

        users = data
        notifyDataSetChanged()

    }
}