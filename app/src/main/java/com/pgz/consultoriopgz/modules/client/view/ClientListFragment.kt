package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.pgz.consultoriopgz.databinding.FragmentListClientsBinding

class ClientListFragment:Fragment() {

    lateinit var _binding:FragmentListClientsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListClientsBinding.inflate(inflater, container, false)
        configureUI()
        configureOnClickListener()
        return _binding.root
    }

    private fun configureUI() {

    }

    private fun configureOnClickListener() {
        _binding.btnAddClient.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(this.id, ClientRegisterFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}