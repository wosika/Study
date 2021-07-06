package com.kale.a5_hilt_http_base.di

import com.kale.a5_hilt_http_base.http.FuelHttpEngine
import com.kale.a5_hilt_http_base.http.IHttp
import com.kale.a5_hilt_http_base.http.OkHttpEngine
import com.kale.a5_hilt_http_base.http.VolleyHttpEngine
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

//统一的返回类型的参数不能一样,函数名也不能一样
abstract class FuelModule {
    @Binds
    @BindFuel
    abstract fun bindsFuel(engine: FuelHttpEngine): IHttp

    @Binds
    @BindOkHttp
    abstract fun bindsOkhttp(engine: OkHttpEngine): IHttp

    @BindVolley
    @Binds
    abstract fun bindsVolley(engine: VolleyHttpEngine): IHttp

}

