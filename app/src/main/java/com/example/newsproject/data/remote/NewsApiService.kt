package com.example.newsproject.data.remote

import com.example.newsproject.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "us"
    ): NewsResponse
}