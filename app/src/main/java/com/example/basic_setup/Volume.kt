package com.example.basic_setup

import com.google.gson.annotations.SerializedName

data class Volume(
    @SerializedName("id")
    var id: Long? = 0,

    @SerializedName("name")
    var name: String? = ""
)