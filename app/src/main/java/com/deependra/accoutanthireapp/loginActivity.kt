package com.deependra.accoutanthireapp

import android.content.Intent
import android.net.http.SslCertificate.saveState
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.deependra.accoutanthireapp.api.ServiceBuilder
import com.deependra.accoutanthireapp.repository.UserRepository
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class loginActivity : AppCompatActivity() {

    private lateinit var etUsername : TextInputEditText
    private lateinit var etPassword : TextInputEditText
    private lateinit var loginLayout : LinearLayout
    private lateinit var btnLogIn : Button
    private lateinit var tvSignUp : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginLayout = findViewById(R.id.loginLayout)
        etUsername = loginLayout.findViewById(R.id.etUsername)
        etPassword = loginLayout.findViewById(R.id.etPassword)
        btnLogIn = loginLayout.findViewById(R.id.btnLogIn)
        tvSignUp = findViewById(R.id.tvSignUp)

        btnLogIn.setOnClickListener {
            login()
//            val username = etUsername.text.toString()
//            val password = etPassword.text.toString()

//            if (username == "admin" && password == "admin") {
//                val intent = Intent(this, UserDashboard_Activity::class.java)
//                startActivity(intent)
//            } else if (username != "admin") {
//                etUsername.error = "please enter valid Username"
//                etUsername.requestFocus()
//
//            } else {
//                etPassword.error = "please check your Password"
//                etPassword.requestFocus()
//
//            }

        }

        tvSignUp.setOnClickListener {
            var intent = Intent(this, sign_up_Activity::class.java)
            //intent.putExtra("user", arrayUser)
            startActivity(intent)
        }


    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()


        CoroutineScope(Dispatchers.IO).launch {
            try {

                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer ${response.token}"

                    saveUsernamePassword()
                    startActivity(
                            Intent(
                                    this@loginActivity,
                                    UserDashboard_Activity::class.java
                            )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                                Snackbar.make(
                                        loginLayout,
                                        "Invalid credentials",
                                        Snackbar.LENGTH_LONG
                                )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }
            } catch (ex: IOException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@loginActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun saveUsernamePassword() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val sharedPref = getSharedPreferences("UsernamePasswordPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }
}

