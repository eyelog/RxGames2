package ru.eyelog.rxgames2.firstgroup.simple_02.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.firstgroup.simple_01.Fragment01
import ru.eyelog.rxgames2.firstgroup.simple_02.Fragment02

@Component(modules = [
    Module02::class,
    RVAdapterModule::class
])
interface Component02 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component02
    }

    fun inject(fragment: Fragment02)
}
