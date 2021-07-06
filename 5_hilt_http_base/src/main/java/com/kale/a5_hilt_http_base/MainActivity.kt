package com.kale.a5_hilt_http_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kale.a5_hilt_http_base.http.HttpCallback
import com.kale.a5_hilt_http_base.http.IHttp
import com.kale.a5_hilt_http_base.http.OkHttpEngine
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.concurrent.thread

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {
            (application as App).httpEngine.get(
                "http://apis.juhe.cn/simpleWeather/query?city=%E8%8B%8F%E5%B7%9E&key=6880a0c6e99ba78cbbf7207fd35528b3",
                params = emptyMap(),
                callback = object : HttpCallback<String>() {
                    override fun callback(result: String) {
                        Log.d(
                            "MainActivity",
                            result + " ${(application as App).httpEngine.javaClass.simpleName}"
                        )
                    }
                })
        }
    }
}