package ru.eyelog.rxgames2.firstgroup.simple_01.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.rxgames2.firstgroup.simple_01.ViewModel01
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory01 @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel01::class.java)) {
            return ViewModel01() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
