package ru.eyelog.rxgames2.secondgroup.simple_04.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.rxgames2.firstgroup.simple_01.ViewModel01
import ru.eyelog.rxgames2.firstgroup.simple_02.ViewModel02
import ru.eyelog.rxgames2.firstgroup.simple_03.ViewModel03
import ru.eyelog.rxgames2.secondgroup.simple_04.ViewModel04
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory04 @Inject constructor(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel04::class.java)) {
            return ViewModel04() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
