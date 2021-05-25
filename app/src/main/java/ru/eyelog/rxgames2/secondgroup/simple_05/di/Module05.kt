package ru.eyelog.rxgames2.secondgroup.simple_05.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.secondgroup.simple_04.ViewModel04
import ru.eyelog.rxgames2.secondgroup.simple_05.ViewModel05

@Module
class Module05 {

    @Provides
    fun provideViewModel05(
        fragment: Fragment,
        factory: ViewModelFactory05
    ): ViewModel05 = ViewModelProvider(fragment, factory).get(ViewModel05::class.java)
}
