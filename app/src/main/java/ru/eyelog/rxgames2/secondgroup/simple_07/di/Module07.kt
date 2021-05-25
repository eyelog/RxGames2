package ru.eyelog.rxgames2.secondgroup.simple_07.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.secondgroup.simple_06.ViewModel06
import ru.eyelog.rxgames2.secondgroup.simple_07.ViewModel07

@Module
class Module07 {

    @Provides
    fun provideViewModel06(
        fragment: Fragment,
        factory: ViewModelFactory07
    ): ViewModel07 = ViewModelProvider(fragment, factory).get(ViewModel07::class.java)
}
