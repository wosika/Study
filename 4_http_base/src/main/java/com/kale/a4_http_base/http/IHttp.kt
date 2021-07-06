package com.kale.a4_http_base.http

import android.annotation.SuppressLint
import android.util.Log
import com.squareup.moshi.Moshi
import java.lang.reflect.ParameterizedType


//定义 http网络请求的接口


//typealias  ICallBack  = (result: String) -> Unit

interface ICallback {
    fun onSuccess(result: String)
    fun onError(error: String)

}


abstract class HttpCallback<T> : ICallback {
    override fun onSuccess(result: String) {
        callback(parseResult(result))
    }

    override fun onError(error: String) {
        Log.e("error", error)
    }

    @SuppressLint("CheckResult")
    private fun parseResult(result: String): T {

        Log.d("Ihttp", result)
        //获取类型对象
        val type = this.javaClass.genericSuperclass
        //获取类型的对象数组
        val params = (type as ParameterizedType).actualTypeArguments

        try {
            val moshi = Moshi.Builder().build()
            val adapter = moshi.adapter<T>(params[0])
            return adapter.fromJson(result)!!
        }catch (e:Exception){
            return result as T
        }

    }

    abstract fun callback(result: T)

}

interface IHttp {
    fun post(url: String, params: Map<String, Any> = emptyMap(), callback: ICallback)

    fun get(url: String, params: Map<String, Any> = emptyMap(), callback: ICallback)
}