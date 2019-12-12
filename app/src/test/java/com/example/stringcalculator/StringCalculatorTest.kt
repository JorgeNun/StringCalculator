package com.example.stringcalculator

import com.example.stringcalculator.calculator.Calculator
import com.example.stringcalculator.calculator.InputNotSupportedException
import com.example.stringcalculator.calculator.NegativeNumberException
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StringCalculatorTest {

    private val scenarios = listOf(
        Pair("", 0),
        Pair("1", 1),
        Pair("1,2", 3),
        Pair("11,22,33", 66),
        Pair("11\n22\n33", 66),
        Pair("11\n22\n33\n", 66)
    )

    @Test
    fun returnsSumOfTheValuesByAnySeparator() {
        scenarios.forEach {
            val result = Calculator.add(it.first)

            assertEquals(it.second, result)
        }
    }

    @Test
    fun string_empty_returns_zero() {
        val result = Calculator.add("")

        assertEquals(0, result)
    }

    @Test
    fun string_with_single_number_returns_number() {
        val result = Calculator.add("56")

        assertEquals(56, result)
    }

    @Test
    fun string_with_number_list_returns_sum_case_A() {
        val result = Calculator.add("1,2")

        assertEquals(3, result)
    }

    @Test
    fun string_with_number_list_returns_sum_case_B() {
        val result = Calculator.add("1,2,3")

        assertEquals(6, result)
    }

    @Test
    fun string_with_number_list_returns_sum_case_C() {
        val result = Calculator.add("11,22,33")

        assertEquals(66, result)
    }

    @Test
    fun string_with_number_list_returns_sum_case_D() {
        val result = Calculator.add("11\n22\n33")

        assertEquals(66, result)
    }

    @Test
    fun string_with_number_list_returns_sum_case_E() {
        val result = Calculator.add("11\n22\n33\n")

        assertEquals(66, result)
    }

    @Test(expected = NegativeNumberException::class)
    fun string_with_negative_number_throws_exception() {
        Calculator.add("1,-1")
    }

    @Test(expected = InputNotSupportedException::class)
    fun string_with_not_covered_separator_throws_exception() {
        val result = Calculator.add("1&2")

        assertEquals(66, result)
    }
}
