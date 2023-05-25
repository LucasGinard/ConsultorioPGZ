package com.pgz.consultoriopgz.modules.modules.scheduleList.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityListScheduleBinding
import com.pgz.consultoriopgz.modules.modules.schedule.view.ScheduleAppointmentActivity
import com.pgz.consultoriopgz.modules.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.modules.modules.scheduleList.presenter.ScheduleListPresenter
import com.pgz.consultoriopgz.modules.utils.SessionCache

class ScheduleListActivity: AppCompatActivity(), ScheduleListContract.View {

    private lateinit var binding: ActivityListScheduleBinding
    private lateinit var presenter: ScheduleListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListScheduleBinding.inflate(layoutInflater)
        presenter = ScheduleListPresenter(this)
        setContentView(binding.root)
        configureUI()
        configureOnClickListeners()
        configureListSchedules()
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
            startActivity(Intent(this, ScheduleAppointmentActivity::class.java))
        }
    }

    private fun configureListSchedules(){
        val adapter = ScheduleListAdapter(SessionCache.listSchedules,this)
        binding.rvSchedules.layoutManager = LinearLayoutManager(this)
        binding.rvSchedules.adapter = adapter
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