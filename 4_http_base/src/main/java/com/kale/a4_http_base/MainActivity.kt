package com.kale.a4_http_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kale.a4_http_base.http.HttpCallback
import com.kale.a4_http_base.http.HttpHelper
import com.kale.a4_http_base.http.ICallback
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        thread {
            HttpHelper.get(
                "http://apis.juhe.cn/simpleWeather/query?city=%E8%8B%8F%E5%B7%9E&key=6880a0c6e99ba78cbbf7207fd35528b3",
                params = emptyMap(),
                callback = object : HttpCallback<String>() {
                    override fun callback(result: String) {
                        Log.d("MainActivity", result + " ${HttpHelper.httpEngine.javaClass.simpleName}")
                    }
                })
        }
    }
}