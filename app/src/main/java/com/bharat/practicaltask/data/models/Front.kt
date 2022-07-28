package com.bharat.practicaltask.data.models

import com.google.gson.annotations.SerializedName

data class Front (

    @SerializedName("key"            ) var key            : String? = null,
    @SerializedName("url"            ) var url            : String? = null,
    @SerializedName("sizeInMegaByte" ) var sizeInMegaByte : Double? = null

)
