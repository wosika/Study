package com.kale.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


fun main(args: Array<String>) {
    val myHello = MyHello()

    //生成代理对象
    val proxy = Proxy.newProxyInstance(
        myHello.javaClass.classLoader,
        myHello.javaClass.interfaces,
        Handler(myHello)
    ) as IHello
    //用代理对象去执行
    proxy.sayHello()
}

//代理处理器
class Handler(val any: Any) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        //可以在此处执行一些操作
        println("执行代理前")
        method?.invoke(any, args)
        println("执行代理后")
      return null
    }
}
