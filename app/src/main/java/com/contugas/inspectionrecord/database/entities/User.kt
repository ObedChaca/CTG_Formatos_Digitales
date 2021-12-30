package com.contugas.inspectionrecord.database.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
  @PrimaryKey(autoGenerate = true)
  val ID: Long = 0,
  val Email: String,
  var Password: String,
  var State: Boolean = true
)
