package ru.eyelog.rxgames2.firstgroup.simple_01.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.firstgroup.simple_01.Fragment01

@Component(modules = [
    Module01::class,
    RVAdapterModule::class
])
interface Component01 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component01
    }

    fun inject(fragment: Fragment01)
}
