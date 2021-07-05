package com.kale.daggerdemo

import android.app.Application
import com.kale.daggerdemo.di.AppComponent
import com.kale.daggerdemo.di.DaggerAppComponent

class App : Application() {

    //提供全局的appComponent
    val appComponent: AppComponent by lazy { DaggerAppComponent.create() }


}