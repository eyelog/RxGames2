package ru.eyelog.rxgames2.secondgroup.simple_07.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.secondgroup.simple_06.Fragment06
import ru.eyelog.rxgames2.secondgroup.simple_07.Fragment07

@Component(modules = [
    Module07::class,
    RVAdapterModule::class
])
interface Component07 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component07
    }

    fun inject(fragment: Fragment07)
}
