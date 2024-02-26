package com.example.randomuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.randomuser.adpater.UserListAdapter
import com.example.randomuser.databinding.FragmentUserListBinding
import com.example.randomuser.model.api.ApiState
import com.example.randomuser.viewmodel.UserViewModel


class UserListFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var binding: FragmentUserListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserListBinding.inflate(layoutInflater)
        userListAdapter = UserListAdapter(arrayListOf()){  selectedUser ->
            findNavController().navigate(UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment2(selectedUser))
        }
        binding.userRecycler.adapter = userListAdapter
        userViewModel.dataState.observe(requireActivity()) { result ->
            when (result) {
                is ApiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), getString(R.string.error_message), Toast.LENGTH_LONG).show()
                }
                is ApiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    userListAdapter.updateData(result.data.results)
                }
                ApiState.Loading -> binding.progressBar.visibility = View.VISIBLE
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}