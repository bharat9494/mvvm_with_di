package com.bharat.practicaltask.data.models

import com.google.gson.annotations.SerializedName

data class CoinResponseData (

    @SerializedName("totalItems"   ) var totalItems   : Int?            = null,
    @SerializedName("startIndex"   ) var startIndex   : Int?            = null,
    @SerializedName("itemsPerPage" ) var itemsPerPage : Int?            = null,
    @SerializedName("list"         ) var list         : ArrayList<Coin> = arrayListOf()

)
