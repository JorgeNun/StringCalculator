package com.example.stringcalculator.login

import java.util.*

const val VALID_INPUT = "admin"

class KataService {

    fun logIn(user: String, pass: String): Boolean = user == VALID_INPUT && pass == VALID_INPUT

    fun logOut(timeProvider: TimeProviderClient): Boolean {
        val second = timeProvider.getSecond()
        return second % 2 == 0
    }
}

interface TimeProviderClient {
    fun getSecond(): Int
}

class TimeProvider : TimeProviderClient {
    override fun getSecond(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.SECOND)
    }
}