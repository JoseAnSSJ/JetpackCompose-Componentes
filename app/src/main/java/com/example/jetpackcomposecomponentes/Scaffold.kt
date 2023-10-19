package com.example.jetpackcomposecomponentes

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    var scaffoldState = rememberScaffoldState()
    val corutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar(onClickIcon = {
            corutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    it
                )
            }
        }, onClickDrawer = {
            corutineScope.launch {
                scaffoldState.drawerState.open()
            }
        })
    },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomBar() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.End,
        drawerContent = { MyDrawer(){
            corutineScope.launch {
                scaffoldState.drawerState.close()
            }
        } },
        drawerGesturesEnabled = false
    ) {

    }
}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit,onClickDrawer: () -> Unit) {
    //val context = LocalContext.current
    TopAppBar(title = { Text(text = "Primera ToolBar") },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 50.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "atras")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Opciones") }) {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "Opciones")
            }
            IconButton(onClick = { onClickIcon("Perfil") }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Perfil")
            }
            IconButton(onClick = { onClickIcon("Favorito") }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav")
            }
        })
}

@Composable
fun MyBottomBar() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Transparent) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "Home"
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite, contentDescription = "Fav"
            )
        }, label = { Text(text = "Fav") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person, contentDescription = "Person"
            )
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = { /*TODO*/ }, backgroundColor = Color.White, contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)

    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Tercera opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Cuarta opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
    }
}