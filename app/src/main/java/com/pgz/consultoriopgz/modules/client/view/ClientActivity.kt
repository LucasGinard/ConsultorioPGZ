package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.pgz.consultoriopgz.databinding.ActivityClientBinding

class ClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
    }

    private fun configureUI(){
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(binding.containerClient.id, ClientListFragment())
        ft.commit()
    }
}