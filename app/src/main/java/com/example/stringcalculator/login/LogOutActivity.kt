package com.example.stringcalculator.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stringcalculator.R
import kotlinx.android.synthetic.main.activity_logout.*

class LogOutActivity : AppCompatActivity(), LogOutPresenterView {

    private val presenter = LogOutPresenter(KataService(), TimeProvider(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
    }

    override fun onResume() {
        super.onResume()
        logoutButton.setOnClickListener {
            presenter.onLogOutButtonClicked()
        }
    }

    override fun goToLoginScreen() {
        finish()
    }

    override fun onBackPressed() {

    }
}

