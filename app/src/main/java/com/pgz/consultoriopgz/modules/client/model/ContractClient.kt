package com.pgz.consultoriopgz.modules.client.model

interface ContractClient {
    interface View{
        fun isValidNewClient()
        fun isNotValidNewClient()
        fun goHome()
    }

    interface Presenter{
        fun validateName(string: String):Boolean
        fun validateLastName(string: String):Boolean
        fun validateId(string: String):Boolean
        fun validateNumber(string: String):Boolean
        fun addClient()
        fun valideForm()
    }
}