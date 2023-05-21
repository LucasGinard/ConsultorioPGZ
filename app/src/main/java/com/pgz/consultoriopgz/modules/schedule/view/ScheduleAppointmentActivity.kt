package com.pgz.consultoriopgz.modules.schedule.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityScheduleAppointmentBinding
import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentContract
import com.pgz.consultoriopgz.modules.schedule.presenter.ScheduleAppointmentPresenter
import com.pgz.consultoriopgz.modules.utils.SessionCache

class ScheduleAppointmentActivity : AppCompatActivity(), ScheduleAppointmentContract.View {

    private lateinit var binding: ActivityScheduleAppointmentBinding
    private lateinit var presenter: ScheduleAppointmentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ScheduleAppointmentPresenter(this)
        configureUI()
        configureOnClickListeners()
        configureSpinners()
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

        binding.editTextDoctor.setOnClickListener {

        }

        binding.editTextDate.setOnClickListener {
            presenter.showDatePicker(this)
        }

        binding.editTextTime.setOnClickListener {
            presenter.showTimePicker(this)
        }
    }

    override fun setDateSelected(date:String) {
        binding.editTextDate.setText(date)
    }

    override fun setTimeSelected(time: String) {
        binding.editTextTime.setText(time)
    }

    private fun configureSpinners(){
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
                    val selectedClient = parent.adapter.getItem(position) as ClientModel
                    binding.editTextClients.setText("${selectedClient.firstName} ${selectedClient.lastName}")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }
}