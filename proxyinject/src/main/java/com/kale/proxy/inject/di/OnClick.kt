package com.kale.proxy.inject.di

import android.view.View
import kotlin.reflect.KClass


//运行时
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@Event("setOnClickListener",View.OnClickListener::class,"onClick")
annotation class OnClick(val id:Int)
