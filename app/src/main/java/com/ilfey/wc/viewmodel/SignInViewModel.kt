package com.ilfey.wc.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ilfey.wc.network.api.RetrofitEnqueue.Companion.Result
import com.ilfey.wc.network.api.RetrofitEnqueue.Companion.enqueue
import com.ilfey.wc.network.api.WDAppService
import com.ilfey.wc.network.model.LoginBody
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val retrofit: WDAppService,
) : ViewModel() {

    fun login(body: LoginBody, callback: (ok: Boolean) -> Unit) {
        retrofit.login(body).enqueue {
            when (it) {
                is Result.Success -> {
                    Log.d(TAG, "login was successful. accessToken: ${it.response.body()?.token}")
                    if (it.response.body() != null) {
                        callback(true)
                    } else {
                        callback(false)
                    }
                }
                is Result.Failure -> {
                    Log.d(TAG, "login failed: ${it.error}")
                    callback(false)
                }
            }
        }
    }

    companion object {
        private const val TAG = "SignInViewModel"
    }
}