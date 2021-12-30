package com.contugas.inspectionrecord

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.contugas.inspectionrecord.application.App
import com.contugas.inspectionrecord.database.entities.User
import com.contugas.inspectionrecord.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {

    //Thread.sleep(1500) //Apply Delay
    setTheme(R.style.Theme_InspectionRecord_Light) //Change Default Theme
    supportActionBar?.hide() //Hide ActionBar
    
    //checkUserSession() //Checked Session

    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    //CREATE
//    lifecycleScope.launch {
//      withContext(Dispatchers.IO) {
//        App.getDB().userDao().insert(
//          User(
//            Email = "example",
//            Password = "1234"
//          )
//        )
//      }
//    }

    //Start Resources
    initApp()


  }


  fun initApp() {
    //Password End Icon
    binding.textInputPassword.isEndIconVisible = false
    binding.editTexPassword.doOnTextChanged { text, _, _, _ ->
      if (text!!.isNotEmpty()) {
        binding.textInputPassword.isEndIconVisible = true
      }
      else {
        binding.textInputPassword.isEndIconVisible = false
      }
    }

    //Login Button
    binding.btnLogin.setOnClickListener { loginUser() }
  }

  fun loginUser() {

    val email = binding.editTexEmail
    val password = binding.editTexPassword

    if (email.text!!.isEmpty()) {
      email.error = "Ingrese su correo"
    }
    if (password.text!!.isEmpty()) {
      password.error = "Ingrese su contraseña"
    }
    else {
      authUser(
        email = email.text!!.toString(),
        password = password.text!!.toString()
      )
    }
  }


  private fun authUser(email: String, password: String) {

    //Loading
    Toast.makeText(
      this,
      "Cargando...",
      Toast.LENGTH_SHORT
    ).show()

    //Coroutine Search
    lifecycleScope.launch {
      withContext(Dispatchers.IO) {
        var user = App.getDB().userDao().findByEmail(email, password)
        if (user == false) {
          runOnUiThread {
            Toast.makeText(
              applicationContext,
              "Datos incorrectos",
              Toast.LENGTH_SHORT
            ).show()
          }
        }
        else {
          accessHome()
        }
      }
    }
  }

  private fun accessHome() {
    //Start HomeActivity
    val activity = HomeActivity::class.java
    val intent = Intent(this, activity)
    //intent.putExtra()
    startActivity(intent)
    finish()
  }

  fun checkUserSession() {
    //Check User Exists
    lifecycleScope.launch {
      withContext(Dispatchers.IO) {
        val userSave = App.getDB().userDao().getAll()
        if (userSave.isNotEmpty()) {
          if (userSave[0].State == true) {
            accessHome()
          }
        }
        else {
          runOnUiThread {
            Toast.makeText(
              applicationContext,
              "Ingrese sus datos",
              Toast.LENGTH_SHORT
            ).show()
          }
        }
      }
    }
  }

}


