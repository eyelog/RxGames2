package ru.eyelog.rxgames2.secondgroup.simple_05.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.secondgroup.simple_04.Fragment04
import ru.eyelog.rxgames2.secondgroup.simple_05.Fragment05

@Component(modules = [
    Module05::class,
    RVAdapterModule::class
])
interface Component05 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component05
    }

    fun inject(fragment: Fragment05)
}
