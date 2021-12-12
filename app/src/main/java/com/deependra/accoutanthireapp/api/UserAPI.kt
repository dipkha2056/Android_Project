package com.deependra.accoutanthireapp.api

import com.deependra.accoutanthireapp.entity.User
import com.deependra.accoutanthireapp.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {
    @POST("signUp/")
    suspend fun registerUser(
            @Body user : User
    ) : Response<LoginResponse>

    @FormUrlEncoded
    @POST("logIn/")
    suspend fun checkUser(
            @Field("userName") userName:String,
            @Field("password") password:String
    ): Response<LoginResponse>
}