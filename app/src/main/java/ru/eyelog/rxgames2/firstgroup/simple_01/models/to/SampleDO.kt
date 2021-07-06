package ru.eyelog.rxgames2.firstgroup.simple_01.models.to

data class SampleDO(
    val id: Long,
    val name: String,
    val number: Int,
    val isChecked: Boolean,
    val typeMode: SampleType,
    val subData: List<SampleSubDO>
)
