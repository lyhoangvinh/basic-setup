package com.example.basic_setup

import com.google.gson.annotations.SerializedName

data class Issues(

    @SerializedName("id")
    var id: Long,

    @SerializedName("date_added")
    var dateAdded: String? = "",

    @SerializedName("date_last_updated")
    var dateLastUpdated: String? = "",

    @SerializedName("image")
    var images: ImageAll,

    @SerializedName("volume")
    var volume: Volume
)