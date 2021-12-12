package com.deependra.accoutanthireapp

import android.net.http.SslCertificate.saveState
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import com.deependra.accoutanthireapp.entity.User
import com.deependra.accoutanthireapp.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class sign_up_Activity : AppCompatActivity() {

    private lateinit var etname: EditText
    private lateinit var etemail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etLoginfrom: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnAddUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_)

        etname = findViewById(R.id.etname)
        etemail = findViewById(R.id.etemail)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etLoginfrom = findViewById(R.id.etLoginfrom)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnAddUser = findViewById(R.id.btnAddUser)


        btnAddUser.setOnClickListener {
            val name = etname.text.toString()
            val email = etemail.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val loginfrom = etLoginfrom.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (password != confirmPassword) {
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            } else {
                val user =
                        User(name = name, email = email, userName = username, password = password, loginfrom = loginfrom)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val userRepository = UserRepository()
                        val response = userRepository.registerUser(user)
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                        this@sign_up_Activity,
                                        "Register successful",
                                        Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                    this@sign_up_Activity,
                                    ex.toString(),
                                    Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
        }





    }
}