package com.andalus.abomedhat.mvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andalus.abomedhat.mvvm.models.User
import com.andalus.abomedhat.mvvm.utils.Constants

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var appDatabase: AppDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null)
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, Constants.DATABASE_NAME).build()
            return appDatabase!!
        }
    }

    abstract fun getUsersDaoDao() : UsersDao
}