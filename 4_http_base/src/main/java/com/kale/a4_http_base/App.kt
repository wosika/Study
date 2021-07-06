package com.kale.a4_http_base

import android.app.Application
import com.kale.a4_http_base.http.FuelHttpEngine
import com.kale.a4_http_base.http.HttpHelper
import com.kale.a4_http_base.http.OkHttpEngine
import com.kale.a4_http_base.http.VolleyHttpEngine

//无缝切换 3种网络框架 
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化网络请求
      //  HttpHelper.init(OkHttpEngine())
     //HttpHelper.init(FuelHttpEngine())
        HttpHelper.init(VolleyHttpEngine(this))
    }
}