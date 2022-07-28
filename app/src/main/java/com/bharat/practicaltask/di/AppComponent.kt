package com.bharat.practicaltask.di

import com.bharat.practicaltask.view.MainActivity
import com.bharat.practicaltask.view.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun inject(main: MainActivity)
    fun inject(home: HomeFragment)
}