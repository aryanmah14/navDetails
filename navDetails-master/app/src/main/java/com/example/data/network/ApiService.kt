package com.example.navdetails.network

import com.example.navdetails.model.NavigationResponses
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("sesapi/navigation")
    suspend fun getNavigation(
        @Query("restApi") restApi: String = "Sesapi",
        @Query("sesapi_platform") platform: Int = 1,
        @Query("auth_token") token: String = "B179086bb56c32731633335762"
    ): NavigationResponses
}

