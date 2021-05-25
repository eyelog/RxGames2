package ru.eyelog.rxgames2.firstgroup.simple_02.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.rxgames2.firstgroup.simple_01.ViewModel01
import ru.eyelog.rxgames2.firstgroup.simple_02.ViewModel02
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory02 @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel02::class.java)) {
            return ViewModel02() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
