package com.contugas.inspectionrecord

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import com.contugas.inspectionrecord.application.App
import com.contugas.inspectionrecord.databinding.ActivityHomeBinding
import com.contugas.inspectionrecord.forms.Form1Activity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity() {

  private lateinit var binding: ActivityHomeBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    //Change Theme
    //setTheme(R.style.Theme_MaterialComponents_Light)

    super.onCreate(savedInstanceState)
    binding = ActivityHomeBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    //Title ActionBar
    supportActionBar?.setTitle("Registro de Formularios")

    Form1()
  }


  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {

    }
    return super.onOptionsItemSelected(item)
  }

  fun Form1() {
    binding.btnForm1.setOnClickListener {
      //Start Form1 Activity
      val activity = Form1Activity::class.java
      val intent = Intent(this, activity)
      //intent.putExtra()
      startActivity(intent)
    }
  }

}