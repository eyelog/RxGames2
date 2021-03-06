package ru.eyelog.rxgames2.datasource.mappers.essential

import kotlin.reflect.KClass

@Repeatable
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class Check(val expressionClass: KClass<out CheckerClass>)

@Repeatable
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class ExcludeCheck(val expressionClass: KClass<out CheckerClass>)

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class NotRequired
