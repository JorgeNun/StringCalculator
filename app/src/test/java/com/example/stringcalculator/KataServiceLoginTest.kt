package com.example.stringcalculator

import com.example.stringcalculator.login.KataService
import com.example.stringcalculator.login.TimeProviderClient
import com.example.stringcalculator.login.VALID_INPUT
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.Serializable


@RunWith(Parameterized::class)
class KataServiceLoginTest(private val input: Pair<String, String>, private val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Serializable>> {
            return listOf(
                arrayOf(Pair(VALID_INPUT, VALID_INPUT), true),
                arrayOf(Pair(VALID_INPUT, "pass"), false),
                arrayOf(Pair("user", VALID_INPUT), false),
                arrayOf(Pair("user", "pass"), false)
            )
        }
    }

    @Test
    fun whenCorrectInputServiceReturnsTrue() {
        assertEquals(expected, KataService().logIn(input.first, input.second))
    }

}

class KataServiceLogOutTest {

    @Test
    fun `when current second is an odd number returns true`() {
        val result = KataService().logOut(MockTimeProvider(2))

        assertEquals(true, result)
    }

    @Test
    fun `when current second is an even number returns false`() {
        val result = KataService().logOut(MockTimeProvider(1))

        assertEquals(false, result)
    }
}

class MockTimeProvider(private val second: Int) : TimeProviderClient {
    override fun getSecond(): Int = second
}