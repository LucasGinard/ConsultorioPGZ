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
import com.pgz.consultoriopgz.modules.utils.SessionCache
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

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
            changeColorSectionSelectDay(it)
        }

        binding.lnTuesday.setOnClickListener {
            changeColorSectionSelectDay(it)
        }

        binding.lnWednesday.setOnClickListener {
            changeColorSectionSelectDay(it)
        }

        binding.lnThursday.setOnClickListener {
            changeColorSectionSelectDay(it)
        }

        binding.lnFriday.setOnClickListener {
            changeColorSectionSelectDay(it)
        }

        binding.lnSaturday.setOnClickListener {
            changeColorSectionSelectDay(it)
        }

        binding.lnSunday.setOnClickListener {
            changeColorSectionSelectDay(it)
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

    private fun changeColorSectionSelectDay(view:View){
        val blueDrawable = ContextCompat.getDrawable(this, R.drawable.background_line_blue)
        val grayDrawable = ContextCompat.getDrawable(this, R.drawable.background_line_gray)

        if (view.background?.constantState == blueDrawable?.constantState) {
            view.background = grayDrawable
        }else{
            view.background = blueDrawable
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