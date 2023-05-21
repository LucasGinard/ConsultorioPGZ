package com.pgz.consultoriopgz.modules.client.presenter

import com.pgz.consultoriopgz.modules.client.model.ContractClient

class ClientPresenter(var view:ContractClient.View):ContractClient.Presenter {

    var isValidName = false
    var isValidNameLastr = false
    var isValidId = false
    var isValidNumber = false

    override fun addClient() {
        TODO("Not yet implemented")
    }

    override fun validateName(nameInput: String): Boolean {
        isValidName = validateInputNotEmptyOrBlank(nameInput)
        disableButtonAddNewClient(isValidName)
        return isValidName
    }

    override fun validateLastName(lastNameInput: String): Boolean {
        isValidNameLastr = validateInputNotEmptyOrBlank(lastNameInput)
        disableButtonAddNewClient(isValidNameLastr)
        return isValidNameLastr
    }

    override fun validateId(idInput: String): Boolean {
        isValidId = validateInputNotEmptyOrBlank(idInput)
        disableButtonAddNewClient(isValidId)
        return isValidId
    }

    override fun validateNumber(numberInput: String): Boolean {
        isValidNumber = validateInputNotEmptyOrBlank(numberInput)
        disableButtonAddNewClient(isValidNumber)
        return isValidNumber
    }

    private fun validateInputNotEmptyOrBlank(input:String):Boolean{
        return input.isNotEmpty()
    }

    private fun disableButtonAddNewClient(isEnable:Boolean){
        if (!isEnable) view.isNotValidNewClient()
    }

    override fun valideForm() {
        if (isValidId && isValidNumber && isValidNameLastr && isValidName){
            view.isValidNewClient()
        }
    }
}