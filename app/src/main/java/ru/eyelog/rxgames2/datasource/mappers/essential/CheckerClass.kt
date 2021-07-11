package ru.eyelog.rxgames2.datasource.mappers.essential

interface CheckerClass {
    /**
     * If check passed this function must return empty string, otherwise string explanation what is
     * wrong
     */
    operator fun invoke(raw: Any): String
}
