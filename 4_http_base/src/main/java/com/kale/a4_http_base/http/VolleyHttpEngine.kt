package com.kale.a4_http_base.http

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class VolleyHttpEngine(private val context: Context) : IHttp {


    val queue = Volley.newRequestQueue(context)


    override fun post(url: String, params: Map<String, Any>, callback: ICallback) {
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                // Display the first 500 characters of the response string.
                callback.onSuccess(response)
            },
            {
                it.printStackTrace()
                callback.onError(error = it.message ?: "网络错误") }) {
            override fun getParams(): MutableMap<String, String> {
                return params.mapValues { it.value.toString() }.toMutableMap()
            }
        }

        queue.add(stringRequest)
    }

    override fun get(url: String, params: Map<String, Any>, callback: ICallback) {
        val stringRequest: Request<String> = object : StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                callback.onSuccess(response)
            },
            {
                it.printStackTrace()
                callback.onError(error = it.message ?: "网络错误") }) {
            override fun getParams(): MutableMap<String, String> {
                return params.mapValues { it.value.toString() }.toMutableMap()
            }
        }
        queue.add(stringRequest)
    }
}