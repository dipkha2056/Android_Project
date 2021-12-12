package com.deependra.accoutanthireapp.api

import com.deependra.accoutanthireapp.response.GetAllAccountantResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface AccountantAPI {

    @GET("accountant/all/")
    suspend fun getAllAccountants(
            @Header("Authorization") token : String,
    ) : Response<GetAllAccountantResponse>
}