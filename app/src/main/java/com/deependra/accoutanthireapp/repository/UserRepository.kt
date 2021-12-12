package com.deependra.accoutanthireapp.repository

import com.deependra.accoutanthireapp.api.ApiRequest
import com.deependra.accoutanthireapp.api.ServiceBuilder
import com.deependra.accoutanthireapp.api.UserAPI
import com.deependra.accoutanthireapp.entity.User
import com.deependra.accoutanthireapp.response.LoginResponse

class UserRepository : ApiRequest() {
    val myApi = ServiceBuilder.buildService(UserAPI ::class.java)

    suspend fun registerUser(user: User): LoginResponse {
        return apiRequest {
            myApi.registerUser(user)
        }
    }

    suspend fun checkUser(userName: String, password: String):LoginResponse{
        return apiRequest {
            myApi.checkUser(userName,password)
        }
    }
}