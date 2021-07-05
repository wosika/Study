package com.kale.daggerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var okHttp: OkHttp

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.injectMainActivity(this)

        Log.d("kale"," okhttp - ${okHttp.hashCode()}")
        Log.d("kale"," retrofit - ${retrofit.hashCode()}")
        Log.d("kale"," retrofit 中的okhttp- ${retrofit.okHttp.hashCode()}")


    }
}