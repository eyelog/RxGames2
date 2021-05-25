package ru.eyelog.rxgames2.secondgroup.simple_04.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.firstgroup.simple_03.Fragment03
import ru.eyelog.rxgames2.secondgroup.simple_04.Fragment04

@Component(modules = [
    Module04::class,
    RVAdapterModule::class
])
interface Component04 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component04
    }

    fun inject(fragment: Fragment04)
}
