package com.pgz.consultoriopgz.modules.scheduleList.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityListScheduleBinding
import com.pgz.consultoriopgz.modules.schedule.view.ScheduleAppointmentActivity
import com.pgz.consultoriopgz.modules.scheduleList.model.ScheduleListContract
import com.pgz.consultoriopgz.modules.scheduleList.presenter.ScheduleListPresenter
import com.pgz.consultoriopgz.utils.SessionCache

class ScheduleListActivity: AppCompatActivity(), ScheduleListContract.View {

    private lateinit var binding: ActivityListScheduleBinding
    private lateinit var presenter: ScheduleListPresenter
    private lateinit var adapter:ScheduleListAdapter

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

        binding.btnDelete.setOnClickListener {
            presenter.removeScheduleCheck(SessionCache.listCheckToDeleteSchedule)
        }
    }

    private fun configureListSchedules(){
        adapter = ScheduleListAdapter(SessionCache.listSchedules,this)
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

    override fun validateButtonTrashVisibility() {
        if (SessionCache.listCheckToDeleteSchedule.isEmpty()){
            binding.btnDelete.visibility = View.GONE
        }else{
            binding.btnDelete.visibility = View.VISIBLE
        }
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun showError() {
        Toast.makeText(this,"Ocurrio un error vuelva a intentarlo",Toast.LENGTH_LONG).show()
    }

}