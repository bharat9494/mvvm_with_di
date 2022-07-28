package com.bharat.practicaltask.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bharat.practicaltask.MyApp
import com.bharat.practicaltask.network.AppRepo
import javax.inject.Inject

class AppViewModelFactory @Inject constructor(private val appRepo: AppRepo) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when(modelClass){
        MainViewModel::class.java -> MainViewModel(appRepo)
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    } as T

}