package com.deependra.accoutanthireapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    private lateinit var btnAccountantLogin : Button
    private lateinit var btnUserlogin : Button
    private lateinit var btnSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnAccountantLogin = findViewById(R.id.btnAccountLogin)
        btnUserlogin = findViewById(R.id.btnUserLogin)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnAccountantLogin.setOnClickListener {
            startActivity(Intent(this@StartActivity,AccountantLogInActivity::class.java))
        }

        btnUserlogin.setOnClickListener {
            startActivity(Intent(this@StartActivity,loginActivity::class.java))
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this@StartActivity,sign_up_Activity::class.java))
        }
    }
}