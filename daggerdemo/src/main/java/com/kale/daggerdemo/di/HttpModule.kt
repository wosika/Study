package com.kale.daggerdemo.di

import com.kale.daggerdemo.OkHttp
import com.kale.daggerdemo.Retrofit
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class HttpModule {
    //提供 需要被注入的对象

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttp = OkHttp()

    @Singleton
    @Provides
    fun provideRetrofit(okHttp: OkHttp): Retrofit = Retrofit(okHttp)

}