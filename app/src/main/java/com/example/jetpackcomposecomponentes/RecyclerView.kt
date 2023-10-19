package com.example.jetpackcomposecomponentes

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecomponentes.model.SuperHero
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Hola1", "Hola2", "Hola3")
    LazyColumn {
        item {
            Text(text = "hola")
        }
        items(7) {
            Text(text = "este es el item $it")
        }
        items(myList) {
            Text(text = it)
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(getSuperHeros()) { superHero ->
            ItemHero(item = superHero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }

}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHeros()) { superHero ->
            ItemHero(item = superHero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }, contentPadding = PaddingValues(16.dp))


}

@Composable
fun SuperHeroSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val showButton by remember {
        derivedStateOf {
            rvState.firstVisibleItemIndex > 0
        }
    }
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeros()) { superHero ->
                ItemHero(item = superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }
        if (showButton) {
            Button(
                onClick = { coroutineScope.launch { rvState.animateScrollToItem(0) } },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Hola")
            }
        }


    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superHero = getSuperHeros().groupBy { it.realName }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        superHero.forEach { (realName, mySuperHero) ->

            stickyHeader {
                Text(
                    text = realName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }

            items(mySuperHero) { superHero ->
                ItemHero(item = superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}

@Composable
fun ItemHero(item: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .width(400.dp)
        .clickable { onItemSelected(item) }) {
        Column {
            Image(
                painter = painterResource(id = item.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = item.superHeroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = item.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = item.publisher, modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 10.dp), fontSize = 10.sp
            )
        }
    }
}

fun getSuperHeros(): List<SuperHero> {

    return listOf(
        SuperHero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverin", "James Howlettr", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odin", "Marvel", R.drawable.thor),
    )
}