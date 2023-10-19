package com.example.jetpackcomposecomponentes.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposecomponentes.model.Routes

@Composable
fun ScreenOne(navController: NavHostController) {
    Box (
        Modifier
            .fillMaxSize()
            .background(Color.Blue)){
        Text(text = "Primera pantalla", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(
            Routes.Pantalla2.route) })
    }
}
@Composable
fun ScreenTwo(navController: NavHostController) {
    Box (
        Modifier
            .fillMaxSize()
            .background(Color.Cyan)){
        Text(text = "Segunda pantalla", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Pantalla3.route) })
    }
}
@Composable
fun ScreenThree(navController: NavHostController) {
    Box (
        Modifier
            .fillMaxSize()
            .background(Color.Green)){
        Text(text = "Tercera pantalla", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Pantalla4.createRout("prueba")) })
    }
}
@Composable
fun ScreenFour(navController: NavHostController, name: String) {
    Box (
        Modifier
            .fillMaxSize()
            .background(Color.Magenta)){
        Text(text = name, modifier = Modifier.align(Alignment.Center).clickable { navController.navigate(Routes.Pantalla5Null.route) })
    }
}
@Composable
fun ScreenFive(navController: NavHostController, age: String) {
    Box (
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)){
        Text(text = "No se pasa${age}", modifier = Modifier.align(Alignment.Center))
    }
}