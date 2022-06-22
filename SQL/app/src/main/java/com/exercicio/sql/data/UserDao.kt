package com.exercicio.sql.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun adduser (usuario: Usuario)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectuser(): LiveData<List<Usuario>>
}