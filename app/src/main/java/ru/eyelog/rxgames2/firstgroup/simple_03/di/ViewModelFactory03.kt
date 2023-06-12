package ru.eyelog.rxgames2.firstgroup.simple_03.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.eyelog.rxgames2.datasource.datagenerators.DataSourceGeneratorDelay
import ru.eyelog.rxgames2.firstgroup.simple_01.ViewModel01
import ru.eyelog.rxgames2.firstgroup.simple_02.ViewModel02
import ru.eyelog.rxgames2.firstgroup.simple_03.ViewModel03
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory03 @Inject constructor(
    private val dataSourceGeneratorDelay: DataSourceGeneratorDelay
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if(modelClass.isAssignableFrom(ViewModel03::class.java)) {
            return ViewModel03(dataSourceGeneratorDelay) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
