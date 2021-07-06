package com.kale.a5_hilt_http_base.http

import okhttp3.*
import java.io.IOException
import javax.inject.Inject


class OkHttpEngine @Inject constructor() : IHttp {
    private val client = OkHttpClient()

    override fun post(url: String, params: Map<String, Any>, callback: ICallback) {
        val builder = FormBody.Builder()

        params.mapKeys {
            builder.add(it.key,it.value.toString())
        }
        val request: Request = Request.Builder()
            .url(url)
            .post(builder.build())
            .build()

        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                callback.onError(e.message ?: "网络错误")
            }

            override fun onResponse(call: Call, response: Response) {
                callback.onSuccess(response.body!!.string())
            }
        })



    }
    override fun get(url: String, params: Map<String, Any>, callback: ICallback) {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                callback.onError(e.message ?: "网络错误")
            }

            override fun onResponse(call: Call, response: Response) {
                callback.onSuccess(response.body!!.string())
            }
        })

    }
}