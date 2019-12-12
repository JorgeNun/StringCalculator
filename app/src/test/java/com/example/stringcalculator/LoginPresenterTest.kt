package com.example.stringcalculator

import com.example.stringcalculator.login.KataService
import com.example.stringcalculator.login.LoginPresenter
import com.example.stringcalculator.login.LoginPresenterView
import com.example.stringcalculator.login.VALID_INPUT
import org.junit.Before
import org.junit.Test

class LoginPresenterTest {

    private lateinit var presenter: LoginPresenter
    private lateinit var loginViewCallback: LoginViewCallback

    @Before
    fun setUp() {
        loginViewCallback = LoginViewCallback()
        presenter = LoginPresenter(KataService(), givenALoginPresenterView(loginViewCallback))
    }

    @Test
    fun `given a LogIn presenter, when user inputs the correct values then we go to log out screen`() {
        presenter.onLoginButtonClicked(VALID_INPUT, VALID_INPUT)
        assert(loginViewCallback.methodWasCalled(LoginViewMethod.GO_TO_LOG_OUT_SCREEN))
    }

    @Test
    fun `given a LogIn presenter, when user inputs a wrong value then we show an error`() {
        presenter.onLoginButtonClicked("Hulk", "1234")
        assert(loginViewCallback.methodWasCalled(LoginViewMethod.SHOW_ERROR))
    }

    private fun givenALoginPresenterView(loginViewCallback: LoginViewCallback) = object : LoginPresenterView {
        override fun goToLogOutScreen() {
            loginViewCallback.addMethod(LoginViewMethod.GO_TO_LOG_OUT_SCREEN)
        }

        override fun showError(error: String) {
            loginViewCallback.addMethod(LoginViewMethod.SHOW_ERROR)
        }
    }

    class LoginViewCallback : BaseCallback<LoginViewMethod>()

    enum class LoginViewMethod {
        GO_TO_LOG_OUT_SCREEN,
        SHOW_ERROR
    }

}