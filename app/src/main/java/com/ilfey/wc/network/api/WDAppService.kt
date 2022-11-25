package com.ilfey.wc.network.api

import com.ilfey.wc.network.model.Login
import com.ilfey.wc.network.model.LoginBody
import com.ilfey.wc.network.model.RegisterBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WDAppService {
    @POST("jwt/register")
    fun register(
        @Body body: RegisterBody
    ): Call<Any>

    @POST("jwt/login")
    fun login(
        @Body body: LoginBody
    ): Call<Login>
}