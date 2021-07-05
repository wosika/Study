package com.kale.proxy.inject

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kale.proxy.inject.di.Injector
import com.kale.proxy.inject.di.OnClick

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Injector.inject(this)
    }

    @OnClick(R.id.btn)
    fun onclick() {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show()
    }

}