package com.kale.a4_http_base.http

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost


class FuelHttpEngine : IHttp {


    override fun post(url: String, params: Map<String, Any>, callback: ICallback) {

        val (_, _, result) = url.httpPost(parameters = params.toList())
            .responseString()

        result.fold({
            callback.onSuccess(it)
        }, {
            it.printStackTrace()
            callback.onError(it.message ?: "网络错误")
        })
    }

    override fun get(url: String, params: Map<String, Any>, callback: ICallback) {
        val (_, _, result) = url.httpGet(parameters = params.toList())
            .responseString()
        result.fold({
            callback.onSuccess(it)
        }, {
            it.printStackTrace()
            callback.onError(it.message ?: "网络错误")
        })
    }


}