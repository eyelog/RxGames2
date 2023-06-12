package ru.eyelog.rxgames2.firstgroup.simple_03.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.rxgames2.datasource.datagenerators.DataSourceGeneratorDelay
import ru.eyelog.rxgames2.firstgroup.simple_02.ViewModel02
import ru.eyelog.rxgames2.firstgroup.simple_03.ViewModel03

@Module
class Module03 {

    @Provides
    fun provideViewModel03(
        fragment: Fragment,
        factory: ViewModelFactory03
    ): ViewModel03 = ViewModelProvider(fragment, factory).get(ViewModel03::class.java)

    @Provides
    fun provideDataSourceGeneratorDelay() = DataSourceGeneratorDelay()
}
