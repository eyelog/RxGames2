package ru.eyelog.rxgames2.firstgroup.simple_03.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import ru.eyelog.rxgames2.adapter.di.RVAdapterModule
import ru.eyelog.rxgames2.firstgroup.simple_02.Fragment02
import ru.eyelog.rxgames2.firstgroup.simple_03.Fragment03

@Component(modules = [
    Module03::class,
    RVAdapterModule::class
])
interface Component03 {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withFragment(fragment: Fragment): Builder

        fun build(): Component03
    }

    fun inject(fragment: Fragment03)
}
