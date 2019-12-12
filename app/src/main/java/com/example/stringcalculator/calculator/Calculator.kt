package com.example.stringcalculator.calculator

object Calculator {

    fun add(input: String): Int {
        val numbersList = input.split(",", "\n").mapNotNull { it.toIntOrNull() }
        return when {
            numbersList.filter { it < 0 }.count() > 0 -> throw NegativeNumberException()
            input.isNotEmpty() && numbersList.isEmpty() -> throw InputNotSupportedException()
            else -> numbersList.sum()
        }
    }
}

class NegativeNumberException : Exception()
class InputNotSupportedException : Exception()