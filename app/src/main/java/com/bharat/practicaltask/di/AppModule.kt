package com.bharat.practicaltask.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.bharat.practicaltask.network.AppRepo
import com.bharat.practicaltask.network.RetrofitService
import com.bharat.practicaltask.viewModel.AppViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
internal class AppModule(private val mApplication: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }

    @Singleton
    @Provides
    fun provideAppRepository(retrofitService: RetrofitService): AppRepo {
        return AppRepo(retrofitService)
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(appRepo: AppRepo): ViewModelProvider.Factory {
        return AppViewModelFactory(appRepo)
    }
}