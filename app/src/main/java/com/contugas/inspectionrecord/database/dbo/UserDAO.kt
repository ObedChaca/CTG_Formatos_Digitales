package com.contugas.inspectionrecord.database.dbo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.contugas.inspectionrecord.database.entities.User


@Dao
interface UserDAO {

  @Query("SELECT * FROM User")
  fun getAll(): List<User>

  @Query("SELECT * FROM User WHERE email = :Email AND password = :Password")
  fun findByEmail(Email: String, Password: String): Boolean

  @Insert
  fun insert(user: User)

  @Query("UPDATE User SET state = :State WHERE email = :Email ")
  fun deleteByEmail(State: Boolean, Email: String)

}