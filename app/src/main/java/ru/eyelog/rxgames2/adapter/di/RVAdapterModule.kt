package ru.eyelog.rxgames2.adapter.di

import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.adapter.RVAdapter

@Module
class RVAdapterModule {

    @Provides
    fun provideRVAdapter() = RVAdapter()
}
