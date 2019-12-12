package com.example.stringcalculator.login

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stringcalculator.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), LoginPresenterView {

    private val presenter = LoginPresenter(KataService(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()

        loginButton.setOnClickListener {
            val userName = username.text.toString()
            val pass = password.text.toString()
            presenter.onLoginButtonClicked(userName, pass)
        }
    }

    override fun goToLogOutScreen() {
        startActivity(Intent(this, LogOutActivity::class.java))
    }

    override fun showError(error: String) {
        AlertDialog.Builder(this).setTitle("Error").setMessage(error).show()
    }
}
