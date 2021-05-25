package ru.eyelog.rxgames2.firstgroup.simple_01.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.firstgroup.simple_01.ViewModel01

@Module
class Module01 {

    @Provides
    fun provideViewModel01(
        fragment: Fragment,
        factory: ViewModelFactory01
    ): ViewModel01 = ViewModelProvider(fragment, factory).get(ViewModel01::class.java)
}
