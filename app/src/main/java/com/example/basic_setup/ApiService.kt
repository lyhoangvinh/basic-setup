package com.example.basic_setup

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("issues")
    fun getIssues(
        @Query("limit") limit: Int, @Query("offset") offset: Int
        , @Query("api_key") api_key: String, @Query("format") format: String
        , @Query("sort") sort: String
    ):
            Call<BaseResponseComic<Issues>>
}