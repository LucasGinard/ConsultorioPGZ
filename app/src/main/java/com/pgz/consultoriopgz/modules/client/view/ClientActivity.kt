package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.ActivityClientBinding
import com.pgz.consultoriopgz.modules.client.model.ClientContract
import com.pgz.consultoriopgz.modules.client.presenter.ClientPresenter

class ClientActivity : AppCompatActivity(), ClientContract.View {

    private lateinit var binding: ActivityClientBinding
    private lateinit var presenter: ClientPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ClientPresenter(this)
        configureUI()
        configureOnClickListeners()
        configureValidateInputs()
    }

    private fun configureValidateInputs(){
        validateInputName()
        validateInputLastName()
        validateInputId()
        validateInputNumber()
    }

    private fun configureUI(){
        binding.header.tvTitleHeader.text = getText(R.string.title_client)
        binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_client))
    }

    private fun configureOnClickListeners(){
        binding.header.btnArrowBack.setOnClickListener {
            finish()
        }

        binding.btnAddClient.setOnClickListener {
            presenter.addClient()
        }
    }

    private fun validateInputName(){
        binding.editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = binding.editTextName.text.toString().trim()
                if (presenter.validateName(inputText)) {
                    binding.nameTextField.error = null
                } else {
                    binding.nameTextField.error = getTextErrorDefault(getString(R.string.input_name))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputLastName(){
        binding.editTextLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = binding.editTextLastName.text.toString().trim()
                if (presenter.validateLastName(inputText)) {
                    binding.nameLastTextField.error = null
                } else {
                    binding.nameLastTextField.error = getTextErrorDefault(getString(R.string.input_last_name))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputId(){
        binding.editTextIdClient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = binding.editTextIdClient.text.toString().trim()
                if (presenter.validateId(inputText)) {
                    binding.idClientTextField.error = null
                } else {
                    binding.idClientTextField.error = getTextErrorDefault(getString(R.string.input_id))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputNumber(){
        binding.editTextNumberClient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = binding.editTextNumberClient.text.toString().trim()
                if (presenter.validateNumber(inputText)) {
                    binding.numberClientTextField.error = null
                } else {
                    binding.numberClientTextField.error = getTextErrorDefault(getString(R.string.input_number))
                }
                presenter.valideForm()
            }
        })
    }

    private fun getTextErrorDefault(inputTitle:String):String{
        return "Porfavor ingrese su ${inputTitle} no puede estar vacío"
    }

    override fun isValidNewClient() {
        binding.btnAddClient.isEnabled = true
    }

    override fun isNotValidNewClient() {
        binding.btnAddClient.isEnabled = false
    }

    override fun goHome() {
        Toast.makeText(this,"Usuario agregado",Toast.LENGTH_LONG).show()
        finish()
    }
}