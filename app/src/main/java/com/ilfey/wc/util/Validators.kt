package com.ilfey.wc.util

import java.util.regex.Pattern

val EMAIL_PATTERN: Pattern = Pattern.compile("^([a-z0-9\\.-])+@[a-z-]+(\\.[a-z-]+)*(\\.[a-z]+)+\$")

fun validateEmail(email: CharSequence): Boolean = EMAIL_PATTERN.matcher(email).matches()