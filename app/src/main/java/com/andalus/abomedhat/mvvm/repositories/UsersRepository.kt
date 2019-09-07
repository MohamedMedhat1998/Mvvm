package com.andalus.abomedhat.mvvm.repositories

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.andalus.abomedhat.mvvm.data.UsersDao
import com.andalus.abomedhat.mvvm.models.User

class UsersRepository(private val dao: UsersDao) {

    fun getAllUsers(): LiveData<List<User>> {
        return dao.getAllUsers()
    }

    fun insertUser(user: User) {
        DBOperationsAsyncTask {
            dao.addUser(user)
        }.execute()
    }

    private class DBOperationsAsyncTask(private val background: () -> Unit) :
        AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            background.invoke()
        }
    }

    fun deleteAllUsers() {
        DBOperationsAsyncTask {
            dao.deleteAll()
        }.execute()
    }


}
