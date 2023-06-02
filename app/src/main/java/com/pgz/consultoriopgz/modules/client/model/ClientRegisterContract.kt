package com.pgz.consultoriopgz.modules.client.model

import com.pgz.consultoriopgz.data.entitys.ClientEntity

interface ClientRegisterContract {
    interface View{
        fun isValidNewClient()
        fun isNotValidNewClient()
        fun goHome()
        fun showError()
    }

    interface Presenter{
        fun validateName(string: String):Boolean
        fun validateLastName(string: String):Boolean
        fun validateId(string: String):Boolean
        fun validateNumber(string: String):Boolean
        fun addClient()
        suspend fun addClientIntoDataBase(client:ClientEntity)
        fun valideForm()
    }
}