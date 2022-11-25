package com.ilfey.wc.network.model

data class RegisterBody (
    val username: String,
    val email: String,
    val password: String,
)