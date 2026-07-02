package com.example.myapplication.data

import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodateApi {
    @GET("most-popular")
    suspend fun getMostPopular(@Query("page") page: Int = 1): TvShowResponse

    @GET("search")
    suspend fun searchShows(@Query("q") query: String, @Query("page") page: Int = 1): TvShowResponse

    @GET("show-details")
    suspend fun getShowDetails(@Query("q") showId: Int): TvShowDetailResponse
}