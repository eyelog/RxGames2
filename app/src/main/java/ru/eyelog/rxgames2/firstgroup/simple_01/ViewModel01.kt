package ru.eyelog.rxgames2.firstgroup.simple_01

import androidx.lifecycle.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames2.datasource.mappers.simple.SimpleMapper
import ru.eyelog.rxgames2.datasource.models.dto.SampleDTO
import ru.eyelog.rxgames2.datasource.models.to.SampleDO
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGenerator

class ViewModel01(
    private val dataSampleGenerator: DataSampleGenerator,
    private val simpleMapper: SimpleMapper
    ): ViewModel(), LifecycleObserver {

    val sampleLiveData: LiveData<List<SampleDO>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<SampleDO>>()

    var data = listOf<SampleDTO>()
    var outData = listOf<SampleDO>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        data = dataSampleGenerator.getDataList(100)
    }

    fun startThread(){

        Single.just(data)
            .map { simpleMapper.mapDTOtoTO(it) }
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
