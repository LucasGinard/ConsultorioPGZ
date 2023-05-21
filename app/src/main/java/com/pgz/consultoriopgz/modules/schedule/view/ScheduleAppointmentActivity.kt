package com.pgz.consultoriopgz.modules.schedule.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityScheduleAppointmentBinding
import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.utils.SessionCache


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

        binding.editTextClients.setOnClickListener {
            binding.spinnerClients.performClick()
        }

        val adapter = NameSpinnerAdapter(this, SessionCache.listClients)
        adapter.setDropDownViewResource(R.layout.item_spinner_client)
        binding.spinnerClients.adapter = adapter

        binding.spinnerClients.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var selectedCity = parent.adapter.getItem(position) as ClientModel

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }
}