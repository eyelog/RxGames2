package ru.eyelog.rxgames2.secondgroup.simple_06.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.secondgroup.simple_05.ViewModel05
import ru.eyelog.rxgames2.secondgroup.simple_06.ViewModel06

@Module
class Module06 {

    @Provides
    fun provideViewModel06(
        fragment: Fragment,
        factory: ViewModelFactory06
    ): ViewModel06 = ViewModelProvider(fragment, factory).get(ViewModel06::class.java)
}
