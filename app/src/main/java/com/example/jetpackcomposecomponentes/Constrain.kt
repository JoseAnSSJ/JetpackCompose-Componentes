package com.example.jetpackcomposecomponentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstrainExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxRed, boxGreen, boxGray, boxBlack) = createRefs()

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    bottom.linkTo(boxBlue.top)
                    start.linkTo(boxBlue.end)

                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxBlue.top)
                    end.linkTo(boxBlue.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    top.linkTo(boxBlue.bottom)
                    end.linkTo(boxBlue.start)
                })
        Box(
            Modifier
                .size(125.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(boxBlue.end)
                })
    }
}

@Composable
fun ConstrainExampleGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.1f)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })
    }

}


@Composable
fun ConstrainExampleBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxRed, boxGreen, boxGray, boxBlack) = createRefs()
        val barrier = createEndBarrier(boxRed,boxBlue)

        Box(
            Modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(parent.start, margin = 16.dp)
                })
        Box(
            Modifier
                .size(225.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(boxBlue.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                })
        Box(
            Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(barrier)
                })

    }

}

@Composable
fun ConstrainExampleChain(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxBlue, boxRed, boxGreen) = createRefs()
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(parent.start)
                    end.linkTo(boxRed.start)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxBlue.end)
                    end.linkTo(boxGreen.start)
                })
        Box(
            Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxRed.end)
                    end.linkTo(parent.end)
                })
        createHorizontalChain(boxBlue,boxRed,boxGreen, chainStyle = ChainStyle.Packed)
    }
}