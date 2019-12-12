package com.example.stringcalculator.login

class LogOutPresenter(private val kataService: KataService, private val timeProvider: TimeProviderClient, private val view: LogOutPresenterView) {

    fun onLogOutButtonClicked() {
        if (kataService.logOut(timeProvider)) {
            view.goToLoginScreen()
        }
    }
}

interface LogOutPresenterView {
    fun goToLoginScreen()
}