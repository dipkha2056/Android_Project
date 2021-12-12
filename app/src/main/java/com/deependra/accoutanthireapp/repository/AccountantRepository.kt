package com.deependra.accoutanthireapp.repository

import android.content.Context
import com.deependra.accoutanthireapp.api.AccountantAPI
import com.deependra.accoutanthireapp.api.ApiRequest
import com.deependra.accoutanthireapp.api.ServiceBuilder
import com.deependra.accoutanthireapp.db.AccountantDB
import com.deependra.accoutanthireapp.entity.Accountant
import com.deependra.accoutanthireapp.response.GetAllAccountantResponse

class AccountantRepository : ApiRequest() {
    val accountantAPI = ServiceBuilder.buildService(AccountantAPI::class.java)
    suspend fun getAllAccountant(context: Context): MutableList<Accountant> {
        val response = apiRequest {
            accountantAPI.getAllAccountants(ServiceBuilder.token!!)
        }

        var accountant = mutableListOf<Accountant>()

        if (response.success == true) {
            val allAccountant : ArrayList<Accountant> = response.data!!

            AccountantDB.getInstance(context).clearAllTables()

            AccountantDB.getInstance(context).getAccountantDAO().insertAccountant(allAccountant)

            accountant = AccountantDB.getInstance(context).getAccountantDAO().getAllAccountants()

        }
        return accountant

    }
}


