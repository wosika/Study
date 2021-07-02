package com.kale.proxy



//运行时
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class OnClick(val id:Int)
