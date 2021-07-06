package ru.eyelog.rxgames2.firstgroup.simple_02.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.rxgames2.datasource.mappers.essential.SampleEssentialMapper
import ru.eyelog.rxgames2.datasource.mappers.essential.SubSampleEssentialMapper
import ru.eyelog.rxgames2.datasource.mappers.simple.SimpleMapper
import ru.eyelog.rxgames2.firstgroup.simple_02.ViewModel02

@Module
class Module02 {

    @Provides
    fun provideViewModel02(
        fragment: Fragment,
        factory: ViewModelFactory02
    ): ViewModel02 = ViewModelProvider(fragment, factory).get(ViewModel02::class.java)

    @Provides
    fun provideDataGenerator() = DataSampleGenerator()

    @Provides
    fun provideSampleEssentialMapper(subSampleEssentialMapper: SubSampleEssentialMapper) =
        SampleEssentialMapper(subSampleEssentialMapper)

    @Provides
    fun provideSubSampleEssentialMapper() = SubSampleEssentialMapper()
}
