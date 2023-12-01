package com.example.lab4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab4.model.Event

class MainActivityViewModel:ViewModel() {
    var lst = MutableLiveData<ArrayList<Event>>()
    var newList = arrayListOf<Event>()
    fun add(event: Event) {
        newList.add(event)
        lst.value = newList
    }
    fun remove(event: Event){
        newList.remove(event)
        lst.value=newList
    }
}