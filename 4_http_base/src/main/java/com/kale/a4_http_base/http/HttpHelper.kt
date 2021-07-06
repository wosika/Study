package com.kale.a4_http_base.http

import com.squareup.moshi.Moshi


//http 网络请求的代理类
object HttpHelper : IHttp {

    //这里需要持有一个真实的网络请求
     lateinit var httpEngine: IHttp

    //需要初始化
    fun init(httpEngine: IHttp) {
        this.httpEngine = httpEngine
    }


    override fun post(url: String, params: Map<String, Any>, callback: ICallback) {
        httpEngine.post(url, params, callback)
    }


    override fun get(url: String, params: Map<String, Any>, callback: ICallback) {
        httpEngine.get(url, params, callback)
    }

}