package com.bharat.practicaltask.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.bharat.practicaltask.data.models.CoinResponse
import com.bharat.practicaltask.network.AppRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class MainViewModel @Inject constructor (val appRepo: AppRepo) : ViewModel() {

//    var repository: AppRepo = AppRepo.getInstance(application)!!
    var coinResponse = MutableLiveData<Response<CoinResponse>>()

    fun getCoinList() = viewModelScope.launch(Dispatchers.IO) {
        val response = appRepo.getCoinList()
        Log.i("TAG", "getCoinList: ${response.body()}")
        coinResponse.postValue(response)
    }

}