package com.pgz.consultoriopgz.modules.client.presenter

import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.modules.client.model.ClientRegisterContract
import com.pgz.consultoriopgz.modules.client.repository.ClientRegisterRepository
import com.pgz.consultoriopgz.utils.SessionCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ClientRegisterPresenter(var view: ClientRegisterContract.View): ClientRegisterContract.Presenter {

    var isValidName = false
    var isValidNameLastr = false
    var isValidId = false
    var isValidNumber = false

    var name:String = ""
    var lastName:String = ""
    var cellphone:String = ""
    var idNumber:Int = 0

    var repository:ClientRegisterRepository = ClientRegisterRepository()

    override fun addClient() {
        val newClient = ClientEntity(name,lastName,idNumber,cellphone)
        GlobalScope.launch(Dispatchers.IO) {
            try {
                addClientIntoDataBase(newClient)
                SessionCache.listClients.add(newClient)
                launch(Dispatchers.Main) {
                    view.goHome()
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    view.showError()
                }
            }
        }
    }

    override suspend fun addClientIntoDataBase(client: ClientEntity) = withContext(Dispatchers.IO) {
        repository.insertClient(client)
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
        idNumber = try {idInput.toInt()}catch(e:Exception){0}
        val validateInputString = if (idNumber == 0) "" else idInput
        isValidId = validateInputNotEmptyOrBlank(validateInputString)
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