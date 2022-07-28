package com.bharat.practicaltask.data.models

import com.google.gson.annotations.SerializedName

data class Pictures (
    @SerializedName("front" ) var front : Front? = Front(),
    @SerializedName("back"  ) var back  : Back?  = Back()
)
