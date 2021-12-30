package com.contugas.inspectionrecord.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.contugas.inspectionrecord.database.dbo.UserDAO
import com.contugas.inspectionrecord.database.entities.User

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

  abstract fun userDao(): UserDAO


  //DB Static
  companion object {
    private var db: AppDB? = null
    fun getDB(context: Context): AppDB {
      if (db == null) {
        db = Room
          .databaseBuilder(
            context,
            AppDB::class.java,
            "database"
          )
          .build()
      }
      return db!!
    }
  }

}