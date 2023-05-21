package com.pgz.consultoriopgz.modules.scheduleList.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityListScheduleBinding

class ScheduleListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityListScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_list)
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_list))
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }
    }

}