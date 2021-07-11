package ru.eyelog.rxgames2.datasource.models.dto

import ru.eyelog.rxgames2.datasource.mappers.essential.Check
import ru.eyelog.rxgames2.datasource.mappers.essential.NotRequired

data class SampleDTO(
    val id: Long,
    @NotRequired val name: String?,
    @NotRequired val number: Int?,
    @NotRequired val isChecked: Boolean?,
    val type: String,
    val subData: List<SampleSubDTO>
)
