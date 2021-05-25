package ru.eyelog.rxgames2.secondgroup.simple_04

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class ViewModel04: ViewModel() {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    val data = mutableListOf<String>()

    fun startThread(){
        data.addAll(listOf("1","2","3"))
        _sampleLiveData.value = data
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }
}
