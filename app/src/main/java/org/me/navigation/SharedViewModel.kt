package org.me.navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val navigate = MutableLiveData<Event<Navigation>>()

}