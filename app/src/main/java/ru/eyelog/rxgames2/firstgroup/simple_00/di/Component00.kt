package ru.eyelog.rxgames2.firstgroup.simple_00.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.firstgroup.simple_00.Fragment00

@Component(modules = [
    Module00::class,
    RVAdapterModule::class
])
interface Component00 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component00
    }

    fun inject(fragment: Fragment00)
}
