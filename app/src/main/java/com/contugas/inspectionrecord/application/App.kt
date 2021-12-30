package com.contugas.inspectionrecord.application

import android.app.Application
import com.contugas.inspectionrecord.database.AppDB

class App : Application() {

  companion object {
    lateinit var prefs: Prefs
    private var db: AppDB? = null
    fun getDB(): AppDB {
      return db!!
    }
  }

  override fun onCreate() {
    super.onCreate()
    prefs = Prefs(applicationContext)
    db = AppDB.getDB(applicationContext)
  }

}