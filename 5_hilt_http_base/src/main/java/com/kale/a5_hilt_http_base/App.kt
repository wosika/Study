package com.kale.a5_hilt_http_base

import android.app.Application
import com.kale.a5_hilt_http_base.di.BindVolley
import com.kale.a5_hilt_http_base.http.IHttp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    @BindVolley
    lateinit var httpEngine: IHttp
}