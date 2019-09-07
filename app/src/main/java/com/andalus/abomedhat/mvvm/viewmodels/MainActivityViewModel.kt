package com.andalus.abomedhat.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andalus.abomedhat.mvvm.models.User
import com.andalus.abomedhat.mvvm.repositories.UsersRepository
import com.andalus.abomedhat.mvvm.utils.RandomUserGenerator

class MainActivityViewModel(private val repository: UsersRepository) : ViewModel() {

    private val isEmpty = MutableLiveData<Boolean>()

    fun getUsersList(): LiveData<List<User>> {
        return repository.getAllUsers()
    }

    fun getIsEmpty(): LiveData<Boolean> {
        return isEmpty
    }

    fun onFabClicked() {
        repository.insertUser(RandomUserGenerator.generate())
    }

    fun onClearOptionSelected() {
        repository.deleteAllUsers()
    }

}