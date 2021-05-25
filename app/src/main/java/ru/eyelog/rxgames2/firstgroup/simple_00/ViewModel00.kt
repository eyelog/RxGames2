package ru.eyelog.rxgames2.firstgroup.simple_00

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class ViewModel00 : ViewModel() {

    val sampleLiveData: LiveData<List<String>> get() = _sampleLiveData
    private val _sampleLiveData = MediatorLiveData<List<String>>()

    private val data = mutableListOf<String>()

    fun startThread() {
        val source = PublishSubject.create<String>()

        source.subscribe(createFirstObserver())
        source.onNext("0")
        source.onNext("1")
        source.onNext("2")

        source.subscribe(createSecondObserver())
        source.onNext("3")
        source.onNext("4")
        source.onNext("5")

        source.onComplete()
    }

    private fun createFirstObserver() = object : Observer<String> {

        override fun onSubscribe(d: Disposable) {
            data.add("First Observer subscribed")
            _sampleLiveData.value = data
        }

        override fun onNext(t: String) {
            data.add("First Observer emit $t")
            _sampleLiveData.value = data
        }

        override fun onError(e: Throwable) {
            data.add("First Observer got error $e")
            _sampleLiveData.value = data
        }

        override fun onComplete() {
            data.add("First Observer completed")
            _sampleLiveData.value = data
        }
    }

    private fun createSecondObserver() = object : Observer<String> {
        override fun onSubscribe(d: Disposable) {
            data.add("Second Observer subscribed")
            _sampleLiveData.value = data
        }

        override fun onNext(t: String) {
            data.add("Second Observer emit $t")
            _sampleLiveData.value = data
        }

        override fun onError(e: Throwable) {
            data.add("Second Observer got error $e")
            _sampleLiveData.value = data
        }

        override fun onComplete() {
            data.add("Second Observer completed")
            _sampleLiveData.value = data
        }
    }

    fun cleanList() {
        data.clear()
        _sampleLiveData.value = data
    }
}
