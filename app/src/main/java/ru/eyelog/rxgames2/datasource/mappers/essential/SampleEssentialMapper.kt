package ru.eyelog.rxgames2.datasource.mappers.essential

import ru.eyelog.rxgames2.datasource.models.dto.SampleDTO
import ru.eyelog.rxgames2.datasource.models.to.SampleDO
import ru.eyelog.rxgames2.datasource.models.to.SampleType
import javax.inject.Inject

class SampleEssentialMapper @Inject constructor(
    val subSampleEssentialMapper: SubSampleEssentialMapper
) : EssentialMapper<SampleDTO, SampleDO>() {
    override fun transform(raw: SampleDTO): SampleDO {
        return raw.run {
            SampleDO(
                id = id,
                name = name,
                number = number,
                isChecked = isChecked,
                typeMode = SampleType.valueByCode(type),
                subData = subData.essentialMap(subSampleEssentialMapper)
            )
        }
    }
}
