package com.example.navdetails.repository


import com.example.navdetails.model.NavigationResponses
import com.example.navdetails.network.RetrofitInstance

class NavigationRepository {
    suspend fun getNavigation(): NavigationResponses {
        return RetrofitInstance.apiService.getNavigation()
    }
}

