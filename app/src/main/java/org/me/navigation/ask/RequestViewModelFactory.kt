package org.me.navigation.ask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RequestViewModelFactory(private val responseValue: Int) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(RequestViewModel::class.java) -> RequestViewModel(responseValue) as T
        else -> throw IllegalArgumentException("ViewModel $modelClass not known")
    }
}