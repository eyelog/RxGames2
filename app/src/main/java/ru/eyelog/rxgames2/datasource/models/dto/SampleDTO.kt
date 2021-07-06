package ru.eyelog.rxgames2.datasource.models.dto

data class SampleDTO(
    val id: Long,
    val name: String,
    val number: Int,
    val isChecked: Boolean,
    val type: String,
    val subData: List<SampleSubDTO>
)
