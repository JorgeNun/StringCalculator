package com.example.stringcalculator

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stringcalculator.login.KataService
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()

        val userName = username.text.toString()
        val pass = password.text.toString()

        loginButton.setOnClickListener {
            if (KataService().logIn(userName, pass)) {
                startActivity(Intent(this, LogOutActivity::class.java))
            } else {
                AlertDialog.Builder(this).setTitle("Error").setMessage("Invalid Credentials!!!").show()
            }
        }
    }
}
