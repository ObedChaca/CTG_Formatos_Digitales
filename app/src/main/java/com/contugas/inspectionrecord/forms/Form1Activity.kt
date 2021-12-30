package com.contugas.inspectionrecord.forms

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.contugas.inspectionrecord.HomeActivity
import com.contugas.inspectionrecord.R
import com.contugas.inspectionrecord.ViewPagerAdapter
import com.contugas.inspectionrecord.databinding.ActivityForm1Binding
import com.google.android.material.tabs.TabLayoutMediator

class Form1Activity : AppCompatActivity() {

  private lateinit var binding: ActivityForm1Binding
  private lateinit var builder: AlertDialog.Builder

  override fun onCreate(savedInstanceState: Bundle?) {
    
    super.onCreate(savedInstanceState)
    binding = ActivityForm1Binding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    //Title ActionBar
    supportActionBar?.title = "Nuevo Registro"

    //Viewpager and TabLayout
    val tabTitle = arrayOf("Información General", "Resultados de Inspección", "Observación")
    val tabTitle2 = resources.getStringArray(R.array.form1Tabs)

    val viewpager = binding.viewPager2
    val titles = binding.tabLayout
    viewpager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

    TabLayoutMediator(titles, viewpager) { tab, position ->
      tab.text = tabTitle2[position]
    }.attach()

    //UI
    initUI()
  }

  fun initUI() {
    val actionBar = supportActionBar
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_form, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {
      R.id.item_btn_save -> {
        onBackPressed()
        return true
      }
      android.R.id.home -> {
        onBackPressed()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  override fun onBackPressed() {

    //AlertDialog onBackPressed
    builder = AlertDialog.Builder(this)
    builder.setTitle("¿Desea salir del registro?")
      .setMessage("Se perderá la información")
      .setCancelable(true)
      .setPositiveButton("Si",
        DialogInterface.OnClickListener { dialog, id ->
          super.onBackPressed()
          finish()
        })
      .setNegativeButton("No",
        DialogInterface.OnClickListener { dialog, id ->
          dialog.cancel()
        })

    builder.create()
    builder.show()

  }

}