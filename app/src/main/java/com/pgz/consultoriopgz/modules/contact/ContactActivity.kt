package com.pgz.consultoriopgz.modules.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pgz.consultoriopgz.databinding.ActivityContactBinding

class ContactActivity: AppCompatActivity() {

    lateinit var binding:ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}