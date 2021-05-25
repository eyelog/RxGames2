package ru.eyelog.rxgames2.firstgroup.simple_00.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.rxgames2.firstgroup.simple_00.ViewModel00
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory00 @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel00::class.java)) {
            return ViewModel00() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
