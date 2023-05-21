package com.pgz.consultoriopgz.modules.scheduleList.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityListScheduleBinding
import com.pgz.consultoriopgz.modules.schedule.view.ScheduleAppointmentActivity
import com.pgz.consultoriopgz.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.modules.scheduleList.presenter.ScheduleListPresenter

class ScheduleListActivity: AppCompatActivity(), ScheduleListContract.View {

    private lateinit var binding: ActivityListScheduleBinding
    private lateinit var presenter:ScheduleListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScheduleBinding.inflate(layoutInflater)
        presenter = ScheduleListPresenter(this)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_list)
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_list))
        presenter.validateListForShowListOrBanner()
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }

        binding.btnAddSchedule.setOnClickListener {
            startActivity(Intent(this,ScheduleAppointmentActivity::class.java))
        }
    }

    override fun showEmptyBanner() {
        binding.rvSchedules.visibility = View.GONE
        binding.showIsEmptySection.visibility = View.VISIBLE
    }

    override fun showListSchedule() {
        binding.rvSchedules.visibility = View.VISIBLE
        binding.showIsEmptySection.visibility = View.GONE
    }

}