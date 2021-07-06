package ru.eyelog.rxgames2.datasource.mappers.simple

import ru.eyelog.rxgames2.datasource.models.dto.SampleDTO
import ru.eyelog.rxgames2.datasource.models.dto.SampleSubDTO
import ru.eyelog.rxgames2.datasource.models.to.SampleDO
import ru.eyelog.rxgames2.datasource.models.to.SampleSubDO
import ru.eyelog.rxgames2.datasource.models.to.SampleType

class SimpleMapper {

    fun mapDTOtoTO(data: List<SampleDTO>): List<SampleDO>{

        val outData = mutableListOf<SampleDO>()

        data.all {
            outData.add(
                SampleDO(
                    id = it.id,
                    name = it.name,
                    number =  it.number,
                    isChecked = it.isChecked,
                    typeMode = SampleType.valueByCode(it.type),
                    subData = mapSubDTOtoSubTO(it.subData)
                )
            )
        }
        return outData
    }

    private fun mapSubDTOtoSubTO(data: List<SampleSubDTO>): List<SampleSubDO>{

        val outData = mutableListOf<SampleSubDO>()

        data.all {
            outData.add(
                SampleSubDO(
                    id = it.id,
                    name = it.name,
                    number =  it.number,
                    isChecked = it.isChecked,
                    typeMode = SampleType.valueByCode(it.type),
                )
            )
        }
        return outData
    }
}
