package com.andalus.abomedhat.mvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andalus.abomedhat.mvvm.repositories.UsersRepository

class MainActivityViewModelFactory(private val repository: UsersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}