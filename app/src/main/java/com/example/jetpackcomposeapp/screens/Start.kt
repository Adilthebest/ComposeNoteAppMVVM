package com.example.jetpackcomposeapp.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeapp.ui.theme.JetpackComposeYoutubeAppTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposeapp.MainViewModel
import com.example.jetpackcomposeapp.MainViewModelFactory
import com.example.jetpackcomposeapp.navigation.NavRoute
import com.example.jetpackcomposeapp.utils.TYPE_DATABASE
import com.example.jetpackcomposeapp.utils.TYPE_FIREBASE

@Composable
fun StartScreen(navController: NavHostController) {
    val context  = LocalContext.current
    val mViewModel :MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application ))
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "What will we use? ")
            Button(
                onClick = {
                    mViewModel.initDataBase(TYPE_DATABASE)
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Room database")
            }
            Button(
                onClick = {
                    mViewModel.initDataBase(TYPE_FIREBASE)
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "FireBase database")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen() {
    JetpackComposeYoutubeAppTheme {
        StartScreen(navController = rememberNavController())
    }
}