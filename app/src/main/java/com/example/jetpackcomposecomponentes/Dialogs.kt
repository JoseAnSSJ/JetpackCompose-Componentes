package com.example.jetpackcomposecomponentes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    var status by remember {
        mutableStateOf("")
    }
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(shape = MaterialTheme.shapes.medium) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    MyTitleDialog(text = "Phone ringthon", Modifier.padding(24.dp))
                    Divider(Modifier.fillMaxWidth(), Color.LightGray)

                    MyRadioButtonList(status) {
                        status = it
                    }
                    Divider(Modifier.fillMaxWidth(), Color.LightGray)
                    Row(
                        Modifier
                            .align(Alignment.End)
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = {}) {
                            Text(text = "Cancel")
                        }
                        TextButton(onClick = {}) {
                            Text(text = "Ok")
                        }
                    }
                }
            }

        }

    }
}

@Composable
fun MyCostumDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Cambio de cuenta")
                AcoutItem("ejemplo1@gmail.com", R.drawable.ic_baseline_face_24)
                AcoutItem("ejemplo2@gmail.com", R.drawable.ic_baseline_supervised_user_circle_24)
                AcoutItem("Añadir nueva cuenta", R.drawable.ic_baseline_add_circle_24)
            }
        }
    }
}

@Composable
fun MySimpleDialogCustom(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Dialog", color = Color.Black)
            }
        }
    }
}

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirmar boton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Ocultar boton")
                }
            })
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier,
        color = Color.Black
    )
}

@Composable
fun AcoutItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }

}