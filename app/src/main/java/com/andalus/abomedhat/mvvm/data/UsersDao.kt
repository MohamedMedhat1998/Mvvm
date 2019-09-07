package com.andalus.abomedhat.mvvm.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andalus.abomedhat.mvvm.models.User

@Dao
interface UsersDao {

    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE name = :name")
    fun getUserByName(name: String): LiveData<List<User>>

    @Insert
    fun addUser(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()

}