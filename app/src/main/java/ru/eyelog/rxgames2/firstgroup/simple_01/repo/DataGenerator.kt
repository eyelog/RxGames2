package ru.eyelog.rxgames2.firstgroup.simple_01.repo

import ru.eyelog.rxgames2.firstgroup.simple_01.models.dto.SampleDTO
import ru.eyelog.rxgames2.firstgroup.simple_01.models.dto.SampleSubDTO
import javax.inject.Inject
import kotlin.random.Random

class DataGenerator @Inject constructor() {

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
                    subData = getSubDetailsList(numb)
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