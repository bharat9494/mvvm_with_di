package com.bharat.practicaltask.data.models

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @SerializedName("result" ) var result : Int?    = null,
    @SerializedName("msg"    ) var msg    : String? = null,
    @SerializedName("data"   ) var data   : CoinResponseData?   = CoinResponseData()
)
