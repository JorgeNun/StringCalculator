package com.example.stringcalculator

import com.example.stringcalculator.login.KataService
import com.example.stringcalculator.login.LogOutPresenter
import com.example.stringcalculator.login.LogOutPresenterView
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LogOutPresenterTest {

    private lateinit var presenter: LogOutPresenter
    private lateinit var loginViewCallback: LogOutViewCallback

    @Before
    fun setUp() {
        loginViewCallback = LogOutViewCallback()
    }

    @Test
    fun `given a LogOut presenter, when user clicks while an odd second, we go to login screen`() {
        presenter = LogOutPresenter(KataService(), MockTimeProvider(2), givenALogOutPresenterView(loginViewCallback))
        presenter.onLogOutButtonClicked()
        assertEquals(true, loginViewCallback.methodWasCalled(LogOutViewMethod.GO_TO_LOG_IN_SCREEN))
    }

    @Test
    fun `given a LogOut presenter, when user clicks while an odd second, we do not go to login screen`() {
        presenter = LogOutPresenter(KataService(), MockTimeProvider(1), givenALogOutPresenterView(loginViewCallback))
        presenter.onLogOutButtonClicked()
        assertEquals(false, loginViewCallback.methodWasCalled(LogOutViewMethod.GO_TO_LOG_IN_SCREEN))
    }

    private fun givenALogOutPresenterView(logOutViewCallback: LogOutViewCallback) = object : LogOutPresenterView {

        override fun goToLoginScreen() {
            logOutViewCallback.addMethod(LogOutViewMethod.GO_TO_LOG_IN_SCREEN)
        }
    }

    class LogOutViewCallback : BaseCallback<LogOutViewMethod>()

    enum class LogOutViewMethod {
        GO_TO_LOG_IN_SCREEN
    }

}