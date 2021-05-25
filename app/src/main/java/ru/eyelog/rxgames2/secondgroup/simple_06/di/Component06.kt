package ru.eyelog.rxgames2.secondgroup.simple_06.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.secondgroup.simple_05.Fragment05
import ru.eyelog.rxgames2.secondgroup.simple_06.Fragment06

@Component(modules = [
    Module06::class,
    RVAdapterModule::class
])
interface Component06 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component06
    }

    fun inject(fragment: Fragment06)
}
