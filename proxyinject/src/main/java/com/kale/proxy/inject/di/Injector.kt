package com.kale.proxy.inject.di

class Injector {

    companion object {
        fun inject(context: Any) {
            //注入时,通过反射寻找类里的所有方法
            val methods = context.javaClass.declaredMethods

            methods.filter {
                it.annotations.isNotEmpty()
            }.map {
                it.annotations.map {annotation ->
                    val annotationClass = annotation.annotationClass
                    //todo  找到注解的注解.

                    println("simpleName  ${ annotation.annotationClass.simpleName}")
                    println("qualifiedName  ${ annotation.annotationClass.qualifiedName}")
                }
            }

        }
    }
}