package com.example.randomuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.randomuser.databinding.FragmentUserDetailsBinding
import com.example.randomuser.databinding.FragmentUserListBinding
import com.example.randomuser.model.Results
import com.example.randomuser.viewmodel.UserViewModel


class UserDetailsFragment : Fragment() {

    private val args: UserDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentUserDetailsBinding
    private lateinit var selectedUser : Results
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         selectedUser = args.Results
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)
        binding.userData = selectedUser
        return binding.root
    }

}