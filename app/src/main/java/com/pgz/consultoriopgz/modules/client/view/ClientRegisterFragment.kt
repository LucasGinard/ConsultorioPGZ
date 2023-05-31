package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.databinding.FragmentRegisterClientBinding
import com.pgz.consultoriopgz.modules.client.model.ClientContract
import com.pgz.consultoriopgz.modules.client.presenter.ClientPresenter

class ClientRegisterFragment: Fragment(), ClientContract.View {

    private lateinit var _binding: FragmentRegisterClientBinding
    private lateinit var presenter: ClientPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterClientBinding.inflate(inflater, container, false)
        presenter = ClientPresenter(this)
        configureUI()
        configureOnClickListeners()
        configureValidateInputs()
        return _binding.root
    }

    private fun configureValidateInputs(){
        validateInputName()
        validateInputLastName()
        validateInputId()
        validateInputNumber()
    }

    private fun configureUI(){
        _binding.header.tvTitleHeader.text = getText(R.string.title_client)
        _binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_client))
    }

    private fun configureOnClickListeners(){
        _binding.header.btnArrowBack.setOnClickListener {
            activity?.onBackPressed()
        }

        _binding.btnAddClient.setOnClickListener {
            presenter.addClient()
        }
    }

    private fun validateInputName(){
        _binding.editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = _binding.editTextName.text.toString().trim()
                if (presenter.validateName(inputText)) {
                    _binding.nameTextField.error = null
                } else {
                    _binding.nameTextField.error = getTextErrorDefault(getString(R.string.input_name))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputLastName(){
        _binding.editTextLastName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = _binding.editTextLastName.text.toString().trim()
                if (presenter.validateLastName(inputText)) {
                    _binding.nameLastTextField.error = null
                } else {
                    _binding.nameLastTextField.error = getTextErrorDefault(getString(R.string.input_last_name))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputId(){
        _binding.editTextIdClient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = _binding.editTextIdClient.text.toString().trim()
                if (presenter.validateId(inputText)) {
                    _binding.idClientTextField.error = null
                } else {
                    _binding.idClientTextField.error = getTextErrorDefault(getString(R.string.input_id))
                }
                presenter.valideForm()
            }
        })
    }

    private fun validateInputNumber(){
        _binding.editTextNumberClient.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = _binding.editTextNumberClient.text.toString().trim()
                if (presenter.validateNumber(inputText)) {
                    _binding.numberClientTextField.error = null
                } else {
                    _binding.numberClientTextField.error = getTextErrorDefault(getString(R.string.input_number))
                }
                presenter.valideForm()
            }
        })
    }

    private fun getTextErrorDefault(inputTitle:String):String{
        return "Porfavor ingrese su ${inputTitle} no puede estar vacío"
    }

    override fun isValidNewClient() {
        _binding.btnAddClient.isEnabled = true
    }

    override fun isNotValidNewClient() {
        _binding.btnAddClient.isEnabled = false
    }

    override fun goHome() {
        Toast.makeText(requireContext(),"Usuario agregado", Toast.LENGTH_LONG).show()
        activity?.onBackPressed()
    }

    override fun showError() {
        Toast.makeText(requireContext(),"No se a guardado vuelva a intentarlo", Toast.LENGTH_LONG).show()
    }
}