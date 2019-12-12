package com.example.stringcalculator.login

class LoginPresenter(private val kataService: KataService, private val view: LoginPresenterView) {

    fun onLoginButtonClicked(userName: String, pass: String) {
        if (kataService.logIn(userName, pass)) {
            view.goToLogOutScreen()
        } else {
            view.showError("Invalid Credentials!!!")
        }
    }
}

interface LoginPresenterView {
    fun showError(error: String)
    fun goToLogOutScreen()
}