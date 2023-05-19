package com.pgz.consultoriopgz.modules.schedule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityScheduleAppointmentBinding

class ScheduleAppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleAppointmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_schedule)
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_schedule))
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }
    }
}