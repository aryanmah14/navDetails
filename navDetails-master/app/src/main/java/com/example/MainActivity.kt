
package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navdetails.ui.NavigationDrawerScreen
import com.example.navdetails.ui.NavigationViewModel
import com.example.navdetails.ui.theme.NavDetailsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavDetailsTheme {
                val navigationViewModel: NavigationViewModel = viewModel()
                NavigationDrawerScreen(viewModel = navigationViewModel)
            }
        }
    }
}
