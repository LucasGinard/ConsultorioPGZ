package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityClientBinding

class ClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_client)
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_client))
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }
    }
}