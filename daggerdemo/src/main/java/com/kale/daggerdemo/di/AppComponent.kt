package com.kale.daggerdemo.di

import com.kale.daggerdemo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
//多个component 不允许使用同一个 作用域 ,当多个component想要单例时,自己创建自定义scope注解.
@Component(modules = [HttpModule::class])
interface AppComponent {
    //提供注入方法
    fun injectMainActivity(activity:MainActivity)
}