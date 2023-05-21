package com.pgz.consultoriopgz.modules.client.presenter

import com.pgz.consultoriopgz.modules.client.model.ClientModel
import com.pgz.consultoriopgz.modules.client.model.ContractClient
import com.pgz.consultoriopgz.modules.utils.SessionCache

class ClientPresenter(var view:ContractClient.View):ContractClient.Presenter {

    var isValidName = false
    var isValidNameLastr = false
    var isValidId = false
    var isValidNumber = false

    var name:String = ""
    var lastName:String = ""
    var cellphone:String = ""
    var idNumber:Int = 0

    override fun addClient() {
        val newClient = ClientModel(name,lastName,idNumber,cellphone)
        SessionCache.listClients.add(newClient)
        view.goHome()
    }

    override fun validateName(nameInput: String): Boolean {
        name = nameInput
        isValidName = validateInputNotEmptyOrBlank(nameInput)
        validateIfIsDisableButtonAddNewClient(isValidName)
        return isValidName
    }

    override fun validateLastName(lastNameInput: String): Boolean {
        lastName = lastNameInput
        isValidNameLastr = validateInputNotEmptyOrBlank(lastNameInput)
        validateIfIsDisableButtonAddNewClient(isValidNameLastr)
        return isValidNameLastr
    }

    override fun validateId(idInput: String): Boolean {
        idNumber = idInput.toInt()
        isValidId = validateInputNotEmptyOrBlank(idInput)
        validateIfIsDisableButtonAddNewClient(isValidId)
        return isValidId
    }

    override fun validateNumber(numberInput: String): Boolean {
        cellphone = numberInput
        isValidNumber = validateInputNotEmptyOrBlank(numberInput)
        validateIfIsDisableButtonAddNewClient(isValidNumber)
        return isValidNumber
    }

    private fun validateInputNotEmptyOrBlank(input:String):Boolean{
        return input.isNotEmpty()
    }

    private fun validateIfIsDisableButtonAddNewClient(isEnable:Boolean){
        if (!isEnable) view.isNotValidNewClient()
    }

    override fun valideForm() {
        if (isValidId && isValidNumber && isValidNameLastr && isValidName){
            view.isValidNewClient()
        }
    }
}