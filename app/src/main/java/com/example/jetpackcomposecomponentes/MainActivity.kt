package com.example.jetpackcomposecomponentes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecomponentes.model.Routes
import com.example.jetpackcomposecomponentes.navigation.ScreenFour
import com.example.jetpackcomposecomponentes.navigation.ScreenOne
import com.example.jetpackcomposecomponentes.navigation.ScreenThree
import com.example.jetpackcomposecomponentes.navigation.ScreenTwo
import com.example.jetpackcomposecomponentes.ui.theme.JetpackComposeComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentesTheme {
                CrossFadeAnimation()
                //VisibilityAnimation()
                //SizeAnimation()
            //ColorAnimation()
                // A surface container using the 'background' color from the theme
/*                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Pantalla1.route
                    ) {
                        composable(Routes.Pantalla1.route) { ScreenOne(navigationController) }
                        composable(Routes.Pantalla2.route) { ScreenTwo(navigationController) }
                        composable(Routes.Pantalla3.route) { ScreenThree(navigationController) }
                        composable(
                            Routes.Pantalla4.route,
                            arguments = listOf(navArgument("name") { type = NavType.StringType })
                        ) { navBackStackEntry ->
                            ScreenFour(
                                navigationController,
                                navBackStackEntry.arguments?.getString("name")!!
                            )
                        }
                        composable(
                            Routes.Pantalla5.route,
                            arguments = listOf(navArgument("age") { defaultValue = "3" })
                        ) { navBackStackEntry ->
                            ScreenFour(
                                navigationController,
                                navBackStackEntry.arguments?.getString("age")!!
                            )
                        }
                    }*/

                    //ScaffoldExample()
                    /*
                                        SuperHeroStickyView()
                                         Column(
                                            Modifier
                                                .fillMaxSize()
                                                .padding(50.dp)
                                        ) {
                                            var show by remember {
                                                mutableStateOf(false)
                                            }
                                            Button(onClick = { show = true }) {
                                                Text(text = "Mostrar dialog")
                                            }
                                            MyConfirmationDialog(
                                                show = show,
                                                onDismiss = { show = false })

                                        }

                                      MyDialog(show = show, onDismiss = {show = false}, onConfirm = {Log.i("prueba", "prueba")})
                                         var selected by remember {
                                            mutableStateOf("Ejemplo")
                                        }
                                        MyRadioButtonList(selected) { selected = it }
                                        Column() {
                                            MyTriStatusCheckBox()
                                            val myOptions = getOptions(titles = listOf("Hola1", "prueba1", "ejemplo1"))
                                            myOptions.forEach {
                                                MyCheckboxWithTextCompleted(it)
                                            }
                                        }
                                        Column() {
                                            var myText by remember { mutableStateOf("") }
                                            MyTextFieldOutLiner(myText){
                                                myText = if (it.contains("a")) {
                                                    it.replace("a", "")
                                                } else {
                                                    it
                                                }
                                            }
                                        }
                    */

                //}
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeComponentesTheme {

    }
}


@Composable
fun MyDropdownMenu() {
    var selectedText by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    val example = listOf("ejemplo 1", "ejemplo 2", "ejemplo 3", "ejemplo 4")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth())
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            example.forEach {
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = it
                }) {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun MyDivider() {
    Divider(modifier = Modifier.fillMaxWidth())
}

@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = { Badge(backgroundColor = Color.Green) { Text(text = "1") } },
        Modifier.padding(16.dp)
    ) {
        Icon(imageVector = Icons.TwoTone.Star, contentDescription = "")
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = Color.LightGray,
        contentColor = Color.Blue
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo",
                onClick = { onItemSelected("Ejemplo") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red, unselectedColor = Color.Blue
                )
            )
            Text(text = "Ejemplo")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo1",
                onClick = { onItemSelected("Ejemplo1") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red, unselectedColor = Color.Blue
                )
            )
            Text(text = "Ejemplo1")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo2",
                onClick = { onItemSelected("Ejemplo2") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red, unselectedColor = Color.Blue
                )
            )
            Text(text = "Ejemplo2")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ejemplo3",
                onClick = { onItemSelected("Ejemplo3") },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red, unselectedColor = Color.Blue
                )
            )
            Text(text = "Ejemplo3")
        }

    }
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state, onClick = { state = !state }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red, unselectedColor = Color.Blue
            )
        )
        Text(text = "ejemplo")
    }

}


@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(title = it, selected = status, onCheckedChange = { myNewStatus ->
            status = myNewStatus
        })
    }

}

@Composable
fun MyCheckboxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckboxWithText() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Hola", modifier = Modifier.padding(vertical = 10.dp))
    }
}

@Composable
fun MyCheckbox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red, uncheckedColor = Color.Yellow, checkmarkColor = Color.Blue
        )
    )

}

@Composable
fun MySwitch() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Switch(
        checked = state, onCheckedChange = { state = !state }, colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Black,
            uncheckedTrackAlpha = 0.2f,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Blue,
            checkedTrackAlpha = 0.5f,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledCheckedTrackColor = Color.Yellow
        )
    )
}

@Composable
fun MyProgresBarAdvance() {
    var loader by rememberSaveable {
        mutableStateOf(0.0f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = loader, modifier = Modifier.padding(24.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                if (loader > 1.0f) {
                    Log.e("error", "no se puede aumentar")
                } else {
                    Log.e("error", loader.toString())
                    loader += 0.1f
                }
            }, modifier = Modifier.padding(24.dp)) {
                Text(text = "Aumentar")
            }
            Button(onClick = {
                if (loader < 0.1f) {
                    Log.e("error", "no se puede reducir")
                } else {
                    loader -= 0.1f
                }
            }, modifier = Modifier.padding(24.dp)) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgresBar() {
    var showLoader by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoader) {

            CircularProgressIndicator(color = Color.Red, strokeWidth = 2.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 24.dp),
                color = Color.Red,
                backgroundColor = Color.Blue
            )
        }

        Button(onClick = { showLoader = !showLoader }) {
            Text(text = if (showLoader) "Ocultar" else "Mostrar")
        }
    }

}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.TwoTone.Star, contentDescription = "hola", tint = Color.Red)
}

@Composable
fun MyImageAdvance() {
    Column() {
        MyIcon()
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            modifier = Modifier.clip(RoundedCornerShape(20f))
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "ejemplo",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Black, shape = CircleShape)
        )
    }

}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample() {
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enable = !enable }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan, contentColor = Color.Red
            ), border = BorderStroke(5.dp, Color.Black), enabled = enable
        ) {
            Text(text = "hola")
        }

        OutlinedButton(
            onClick = { enable = !enable },
            modifier = Modifier.padding(24.dp),
            colors = ButtonDefaults.buttonColors(
                disabledBackgroundColor = Color.Cyan, disabledContentColor = Color.Red
            ),
            enabled = !enable
        ) {
            Text(text = "hola1")
        }
    }
}

@Composable
fun MyTextFieldOutLiner(name: String, onValueChange: (String) -> Unit) {


    OutlinedTextField(value = name,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "Introduce tu nombre") },
        modifier = Modifier.padding(24.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Red
        )
    )

}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Introduce tu nombre") })


}

@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }

    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Ejemplo")
        Text(text = "Ejemplo", color = Color.Blue)
        Text(text = "Ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Ejemplo", fontWeight = FontWeight.ExtraLight)
        Text(text = "Ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "Ejemplo", fontSize = 30.sp)
        Text(
            text = "Ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough, TextDecoration.Underline
                    )
                )
            )
        )

    }
}

