package com.example.stringcalculator

import com.example.stringcalculator.calculator.Calculator
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class CalculatorUnitTest(private val input: String, private val expected: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("", 0),
                arrayOf("1", 1),
                arrayOf("1,2", 3),
                arrayOf("1,2,3,4", 10),
                arrayOf("11,22,33", 66),
                arrayOf("11\n22\n33", 66),
                arrayOf("11\n22\n33\n", 66)
            )
        }
    }
    @Test
    fun `given a calculator when different inputs sum is returned`() {
        assertEquals(expected, Calculator.add(input))
    }
}
