package com.contugas.inspectionrecord.application

import android.content.Context

class Prefs(private val context: Context) {

  val SHARED_NAME = "UserSession"
  val SHARED_USER = "user"
  val storage = context.getSharedPreferences(SHARED_NAME, 0)

  fun saveUser(name: String) {
    storage.edit().putString(SHARED_USER, name).apply()
  }

  fun getUser(): String {
    return storage.getString(SHARED_USER, "")!!
  }

}