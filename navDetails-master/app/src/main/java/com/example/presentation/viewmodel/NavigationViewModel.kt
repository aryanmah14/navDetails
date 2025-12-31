package com.example.navdetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navdetails.model.Menu
import com.example.navdetails.repository.NavigationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NavigationViewModel : ViewModel() {

    private val repository = NavigationRepository()

    private val _menus = MutableStateFlow<List<Menu>>(emptyList())
    val menus: StateFlow<List<Menu>> = _menus

    private val _userPhoto = MutableStateFlow("")
    val userPhoto: StateFlow<String> = _userPhoto

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    init {
        getNavigationData()
    }

    private fun getNavigationData() {
        viewModelScope.launch {
            try {
                val response = repository.getNavigation()
                _menus.value = response.result.menus
                _userPhoto.value = response.result.user_photo
                _userName.value = response.result.title
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

