package com.example.stringcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stringcalculator.login.KataService
import com.example.stringcalculator.login.TimeProvider
import kotlinx.android.synthetic.main.activity_logout.*

class LogOutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
    }

    override fun onResume() {
        super.onResume()
        logoutButton.setOnClickListener {
            if (KataService().logOut(TimeProvider())) {
                finish()
            }
        }
    }

    override fun onBackPressed() {

    }
}

