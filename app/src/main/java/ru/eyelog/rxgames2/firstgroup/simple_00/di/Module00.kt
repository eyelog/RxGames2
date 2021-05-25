package ru.eyelog.rxgames2.firstgroup.simple_00.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.firstgroup.simple_00.ViewModel00

@Module
class Module00 {

    @Provides
    fun provideViewModel00(
        fragment: Fragment,
        factory: ViewModelFactory00
    ): ViewModel00 = ViewModelProvider(fragment, factory).get(ViewModel00::class.java)
}
