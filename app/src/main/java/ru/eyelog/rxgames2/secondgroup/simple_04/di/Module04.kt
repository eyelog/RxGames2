package ru.eyelog.rxgames2.secondgroup.simple_04.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.firstgroup.simple_03.ViewModel03
import ru.eyelog.rxgames2.secondgroup.simple_04.ViewModel04

@Module
class Module04 {

    @Provides
    fun provideViewModel04(
        fragment: Fragment,
        factory: ViewModelFactory04
    ): ViewModel04 = ViewModelProvider(fragment, factory).get(ViewModel04::class.java)
}
