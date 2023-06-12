package ru.eyelog.rxgames2.datasource.datagenerators

import javax.inject.Inject

class DataSourceGeneratorDelay @Inject constructor() {

    fun getSomeData(): List<String>{

        Thread.sleep(5000L)

        val outList = mutableListOf<String>()

        for (i in 0..5){
            outList.add(
                "number = $i, Delayed item = 5000L"
            )
        }
        return outList.toList()
    }
}