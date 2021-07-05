package com.kale.proxy.inject.di

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
//事件三要素  函数名  接口  回调函数名
annotation class Event(
    val method: String,
     val interfaceClass: KClass<*>,
    val callbackMethod: String
)
