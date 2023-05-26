package com.pgz.consultoriopgz.modules.schedule.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityScheduleAppointmentBinding
import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.schedule.model.ScheduleAppointmentContract
import com.pgz.consultoriopgz.modules.schedule.presenter.ScheduleAppointmentPresenter
import com.pgz.consultoriopgz.utils.SessionCache

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
        val blueDrawable = ContextCompat.getDrawable(this, R.drawable.background_line_blue)
        binding.lnMonday.background = blueDrawable
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }

        binding.editTextClients.setOnClickListener {
            binding.spinnerClients.performClick()
        }


        binding.editTextDate.setOnClickListener {
            presenter.showDatePicker(this)
        }

        binding.editTextTime.setOnClickListener {
            presenter.showTimePicker(this)
        }

        binding.btnAddSchedule.setOnClickListener {
            presenter.addNewScheduleAppointment()
        }

        binding.btnClean.setOnClickListener {
            binding.editTextDate.setText("")
            binding.editTextTime.setText("")
            binding.editTextClients.setText("")
            binding.editTextAmount.setText("")
            binding.editTextMedicineName.setText("")
            presenter.cleanInputs()
        }

        binding.lnMonday.setOnClickListener {
            changeColorSectionSelectDay(it,0)
        }

        binding.lnTuesday.setOnClickListener {
            changeColorSectionSelectDay(it,1)
        }

        binding.lnWednesday.setOnClickListener {
            changeColorSectionSelectDay(it,2)
        }

        binding.lnThursday.setOnClickListener {
            changeColorSectionSelectDay(it,3)
        }

        binding.lnFriday.setOnClickListener {
            changeColorSectionSelectDay(it,4)
        }

        binding.lnSaturday.setOnClickListener {
            changeColorSectionSelectDay(it,5)
        }

        binding.lnSunday.setOnClickListener {
            changeColorSectionSelectDay(it,6)
        }

        binding.editTextAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                binding.editTextAmount.removeTextChangedListener(this)

                binding.editTextAmount.setText(presenter.setFormatDecimalMoney(s.toString()))
                presenter.validateFormSchedule()
                binding.editTextAmount.text
                    ?.let { binding.editTextAmount.setSelection(it.length) }

                binding.editTextAmount.addTextChangedListener(this)

                val inputText = binding.editTextAmount.text.toString().trim()
                if (presenter.validateInputAmount(inputText)) {
                    binding.amounttextInputLayout.error = null
                } else {
                    binding.amounttextInputLayout.error = "Porfavor ingrese un monto"
                }
            }
        })

        binding.editTextMedicineName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val inputText = binding.editTextMedicineName.text.toString().trim()
                if (presenter.validateInputNameMedicine(inputText)) {
                    binding.medicineNameTextInputLayout.error = null
                } else {
                    binding.medicineNameTextInputLayout.error = "Porfavor ingrese el nombre del medicamento"
                }
            }
        })
    }

    override fun setDateSelected(date:String) {
        presenter.validateFormSchedule()
        binding.editTextDate.setText(date)
    }

    override fun setTimeSelected(time: String) {
        presenter.validateFormSchedule()
        binding.editTextTime.setText(time)
    }

    override fun goHome() {
        Toast.makeText(this,"registrada exitosamente", Toast.LENGTH_LONG).show()
        finish()
    }

    override fun isValidNewSchedule() {
        binding.btnAddSchedule.isEnabled = true
        binding.btnClean.isEnabled = true
    }

    override fun isNotValidNewSchedule() {
        binding.btnAddSchedule.isEnabled = false
        binding.btnClean.isEnabled = false
    }

    private fun changeColorSectionSelectDay(view:View,dayClicked:Int){
        val blueDrawable = ContextCompat.getDrawable(this, R.drawable.background_line_blue)
        val grayDrawable = ContextCompat.getDrawable(this, R.drawable.background_line_gray)

        if (view.background?.constantState == blueDrawable?.constantState) {
            setCheckorNotClicked(dayClicked,false)
            view.background = grayDrawable
        }else{
            setCheckorNotClicked(dayClicked,true)
            view.background = blueDrawable
        }
    }

    private fun setCheckorNotClicked(dayClicked: Int,isCheck:Boolean){
        when(dayClicked){
            0 -> presenter.daysSelected.monday = isCheck
            1 -> presenter.daysSelected.tuesday = isCheck
            2 -> presenter.daysSelected.wednesday = isCheck
            3 -> presenter.daysSelected.thursday = isCheck
            4 -> presenter.daysSelected.friday = isCheck
            5 -> presenter.daysSelected.saturday = isCheck
            6 -> presenter.daysSelected.sunday = isCheck
        }
    }

    private fun configureSpinners(){
        val adapterClientes = NameSpinnerAdapter(this, SessionCache.listClients)
        adapterClientes.setDropDownViewResource(R.layout.item_spinner_client)
        binding.spinnerClients.adapter = adapterClientes

        binding.spinnerClients.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    presenter.selectClient = parent.adapter.getItem(position) as ClientModel
                    presenter.validateFormSchedule()
                    binding.editTextClients.setText("${presenter.selectClient?.firstName} ${presenter.selectClient?.lastName}")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }
}