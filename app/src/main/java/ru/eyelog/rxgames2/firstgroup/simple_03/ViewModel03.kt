package ru.eyelog.rxgames2.firstgroup.simple_03

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ListAdapter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGenerator
import ru.eyelog.rxgames2.datasource.datagenerators.DataSampleGeneratorMaybe
import ru.eyelog.rxgames2.datasource.datagenerators.DataSourceGeneratorDelay
import ru.eyelog.rxgames2.datasource.mappers.essential.SampleEssentialMapper
import javax.inject.Inject

class ViewModel03 @Inject constructor(
    private val dataSourceGeneratorDelay: DataSourceGeneratorDelay
): ViewModel() {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    val data = mutableListOf<String>()

    fun startThread(){
        getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                _sampleLiveData.value = data
            }
            .addTo(CompositeDisposable())


    }

    private fun getData(): Single<List<String>>{
        return Single.fromCallable {
            dataSourceGeneratorDelay.getSomeData()
        }
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }
}
