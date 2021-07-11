package ru.eyelog.rxgames2.firstgroup.simple_02

import androidx.lifecycle.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGeneratorMaybe
import ru.eyelog.rxgames2.datasource.mappers.essential.SampleEssentialMapper
import ru.eyelog.rxgames2.datasource.mappers.essential.essentialMap
import ru.eyelog.rxgames2.datasource.mappers.essential.essentialSingleListMap
import ru.eyelog.rxgames2.datasource.mappers.simple.SimpleMapper
import ru.eyelog.rxgames2.datasource.models.dto.SampleDTO
import ru.eyelog.rxgames2.datasource.models.to.SampleDO
import javax.inject.Inject

class ViewModel02 @Inject constructor(
    private val dataSampleGenerator: DataSampleGenerator,
    private val dataSampleGeneratorMaybe: DataSampleGeneratorMaybe,
    private val sampleEssentialMapper: SampleEssentialMapper
): ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<SampleDO>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<SampleDO>>()

    var data = listOf<SampleDTO>()
    var outData = listOf<SampleDO>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        data = dataSampleGeneratorMaybe.getDataList(10)
    }

    fun startThread(){

        Single.just(data)
            .essentialSingleListMap(sampleEssentialMapper)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                _sampleLiveData.value = data
            }
            .addTo(CompositeDisposable())
    }

    fun cleanList() {
        outData = listOf()
        _sampleLiveData.value = outData
    }
}
