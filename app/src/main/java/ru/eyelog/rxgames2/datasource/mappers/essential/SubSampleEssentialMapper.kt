package ru.eyelog.rxgames2.datasource.mappers.essential

import ru.eyelog.rxgames2.datasource.models.dto.SampleSubDTO
import ru.eyelog.rxgames2.datasource.models.to.SampleSubDO
import ru.eyelog.rxgames2.datasource.models.to.SampleType
import javax.inject.Inject

class SubSampleEssentialMapper @Inject constructor() : EssentialMapper<SampleSubDTO, SampleSubDO>() {
    override fun transform(raw: SampleSubDTO): SampleSubDO {
        return raw.run {
            SampleSubDO(
                id = id,
                name = name.orDefault(),
                number =  number.orDefault(),
                isChecked = isChecked.orDefault(),
                typeMode = SampleType.valueByCode(type)
            )
        }
    }
}
