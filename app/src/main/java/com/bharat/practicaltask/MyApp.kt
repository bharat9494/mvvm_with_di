package com.bharat.practicaltask

import android.app.Application
import com.bharat.practicaltask.di.ApiModule
import com.bharat.practicaltask.di.AppComponent
import com.bharat.practicaltask.di.AppModule
import com.bharat.practicaltask.di.DaggerAppComponent
import com.bharat.practicaltask.utils.baseUrl


class MyApp : Application() {

    companion object {
        private lateinit var appComponent: AppComponent
        lateinit var instance: MyApp

        fun getComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule(baseUrl))
            .build();
    }

}