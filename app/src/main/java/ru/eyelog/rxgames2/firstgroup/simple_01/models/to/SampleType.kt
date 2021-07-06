package ru.eyelog.rxgames2.firstgroup.simple_01.models.to

enum class SampleType(val code: String) {
    FIRST_TYPE ("first type"),
    SECOND_TYPE ("second type"),
    THIRD_TYPE ("third type");

    companion object {
        fun valueByCode(code: String): SampleType = code.let {
            values().find { it.code == code } ?: FIRST_TYPE
        }
    }
}
