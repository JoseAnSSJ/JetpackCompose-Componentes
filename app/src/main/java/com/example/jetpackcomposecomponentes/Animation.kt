package com.example.jetpackcomposecomponentes

import android.opengl.Visibility
import android.transition.Slide
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimation() {
    var show by rememberSaveable {
        mutableStateOf(true)
    }
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    val realColor = if (firstColor) Color.Red else Color.Blue

    var secondColor by rememberSaveable {
        mutableStateOf(false)
    }
    val secondRealColor = animateColorAsState(
        targetValue = if (secondColor) Color.Red else Color.Blue, label = "asdasdasdsada"
    )

    var thirdColor by rememberSaveable {
        mutableStateOf(false)
    }
    val thirdRealColor = animateColorAsState(
        targetValue = if (thirdColor) Color.Red else Color.Blue,
        label = "asdasdasdsada",
        animationSpec = tween(durationMillis = 2000)
    )

    var fourthColor by rememberSaveable {
        mutableStateOf(false)
    }
    val fourthRealColor =
        animateColorAsState(targetValue = if (fourthColor) Color.Red else Color.Blue,
            label = "asdasdasdsada",
            animationSpec = tween(durationMillis = 4000),
            finishedListener = {
                show = false
            })
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (show) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(color = realColor)
                .clickable { firstColor = !firstColor })
            Spacer(modifier = Modifier.size(20.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .background(color = secondRealColor.value)
                .clickable { secondColor = !secondColor })
            Spacer(modifier = Modifier.size(20.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .background(color = thirdRealColor.value)
                .clickable { thirdColor = !thirdColor })
            Spacer(modifier = Modifier.size(20.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .background(color = fourthRealColor.value)
                .clickable { fourthColor = !fourthColor })

        } else {
            Button(onClick = { show = true }) {
                Text(text = "Mostrar")
            }
        }


    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    var size = if (smallSize) 50.dp else 100.dp
    var firstSmallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val firstSize by animateDpAsState(
        targetValue = if (firstSmallSize) 50.dp else 100.dp, label = "ok"
    )
    var secondSmallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val secondSize by animateDpAsState(
        targetValue = if (secondSmallSize) 50.dp else 100.dp,
        tween(durationMillis = 4000),
        label = "ok"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(size)
            .background(color = Color.Black)
            .clickable { smallSize = !smallSize })
        Spacer(modifier = Modifier.size(20.dp))
        Box(modifier = Modifier
            .size(firstSize)
            .background(color = Color.Black)
            .clickable { firstSmallSize = !firstSmallSize })
        Spacer(modifier = Modifier.size(20.dp))
        Box(modifier = Modifier
            .size(secondSize)
            .background(color = Color.Black)
            .clickable { secondSmallSize = !secondSmallSize })
    }
}


@Composable
fun VisibilityAnimation(){

    var isVisible by remember {
        mutableStateOf(true)
    }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Accion")
        }
        AnimatedVisibility (visible = isVisible) {
            Spacer(modifier = Modifier.size(20.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Gray))
        }
    }
}

@Composable
fun CrossFadeAnimation(){
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { myComponentType = getComponentRandom() }) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponentType, label = "Hola"){
            when(it){
                ComponentType.Image ->{
                    Icon(Icons.Default.Favorite, contentDescription = "hola")}
                ComponentType.Text ->{
                    Text(text = "Hola")
                }
                ComponentType.Box ->{
                    Box(modifier = Modifier
                        .size(200.dp)
                        .background(Color.Blue))}
                ComponentType.Error -> {
                    Text(text = "Error")
                }
            }
        }

    }

}

fun getComponentRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3 )){
        0 -> ComponentType.Text
        1 -> ComponentType.Box
        2 -> ComponentType.Image
        else -> ComponentType.Error
    }

}

enum class ComponentType(){
    Image,Text,Box,Error
}