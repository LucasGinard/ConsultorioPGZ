package com.pgz.consultoriopgz.modules.about

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityAboutBinding

class AboutActivity: AppCompatActivity() {

    lateinit var binding:ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_about)
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }

        binding.btnMoreInfo.setOnClickListener {
            Toast.makeText(this,"",Toast.LENGTH_LONG).show()
        }
    }
}