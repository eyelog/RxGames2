package ru.eyelog.rxgames2.datasource.datagenerators

import ru.eyelog.rxgames2.datasource.models.dto.SampleDTO
import ru.eyelog.rxgames2.datasource.models.dto.SampleSubDTO
import javax.inject.Inject
import kotlin.random.Random

class DataSampleGenerator @Inject constructor() {

    private val someTypes = arrayListOf("first type", "second type", "third type")

    fun getDataList(numb: Int): List<SampleDTO>{

        val outData = mutableListOf<SampleDTO>()

        for (i in 0..numb){

            outData.add(
                SampleDTO(
                    id = i.toLong(),
                    name = "name $i",
                    number = i,
                    isChecked = Random.nextBoolean(),
                    type = someTypes[Random.nextInt(3)],
                    subData = getSubDetailsList(2)
                )
            )
        }

        return outData
    }

    private fun getSubDetailsList(numb: Int): List<SampleSubDTO>{

        val outData = mutableListOf<SampleSubDTO>()

        for (i in 0..numb){

            outData.add(
                SampleSubDTO(
                    id = i.toLong(),
                    name = "subname name $i",
                    number = i,
                    isChecked = Random.nextBoolean(),
                    type = someTypes[Random.nextInt(3)]
                )
            )
        }

        return outData
    }
}