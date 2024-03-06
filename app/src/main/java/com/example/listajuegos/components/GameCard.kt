package com.example.listajuegos.components


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listajuegos.R
import com.example.listajuegos.models.Game
import com.example.listajuegos.ui.theme.GreenDollar
import com.example.listajuegos.ui.theme.ListaJuegosTheme

@Composable
fun GameCard(game: Game) {


    /*
        var name : String = "Resident Evil 4 for PS4"
        var console: String = "Multiplataforma"
        var price: Int = 1200
        var image: Int = R.drawable.resident
    */




    /*Modificadores
    https://developer.android.com/jetpack/compose/modifiers?hl=es-419
     */

    /*

    https://abhichn.medium.com/how-to-create-a-list-in-jetpack-compose-using-lazycolumn-d8a6beb5bf65

     elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
            contentColor = Color.Green
        ),
        border = BorderStroke(5.dp, Color.Green)
     */

    Card(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .wrapContentHeight(),
        /*colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Magenta
        ),
        border = BorderStroke(2.dp, Color.Gray)*/
    ) {
        Row(
            Modifier.height(IntrinsicSize.Min), // ajustar el Column Interior a la alutra del row
            verticalAlignment = Alignment.Top
            //Modifier.background(Color.Green)

        ) {

            Image(
                painter = painterResource(id = game.image),
                contentDescription = "imagen del juego",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(160.dp)
                    .width(100.dp)
                //  .background(Color.Red),
                // alpha = 0.5f

            )

            DataColumn(game)


        }
    }
}

@Composable
fun DataColumn(game: Game) {

    Column(
        Modifier
            .padding(8.dp)
            .fillMaxSize()
        // .height(intrinsicSize = IntrinsicSize.Max)
        //  .background(Color.Red)
        ,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {

        TitleGame(game.name)
        //Spacer(modifier = Modifier.padding(top = 4.dp))
        TopSpacer()
        ConsoleAndPriceRow(game)
        TopSpacer(size = 16.dp)
        BuyButton(game, Modifier.align(alignment = Alignment.End))
    }
}

@Composable
fun TitleGame(name: String) {
    Text(
        text = name,
        fontSize = 24.sp,
        color = Color(0xFF9C27B0),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Cursive,
        maxLines = 1
    )
}

@Composable
fun BuyButton(game: Game, modifier: Modifier) {
    var context = LocalContext.current
    Button(
        onClick = {
            showToastBoughtGame(game, context)
        },
        modifier = modifier
    ) {
        Text("Comprar")
    }
}

fun showToastBoughtGame(game: Game, context: Context){

    if (game.price < 2000) {
        Toast.makeText(
            context,
            "Juego ${game.name} comprado a tan solo ${game.price}",
            Toast.LENGTH_SHORT
        ).show()
    }else{
        Toast.makeText(
            context,
            "Te tranzaron con el juego ${game.name} a ${game.price}",
            Toast.LENGTH_LONG
        ).show()
    }
}

@Composable
fun ConsoleAndPriceRow(game: Game) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(
            text = game.console,
            modifier = Modifier.weight(1f)
                 .wrapContentWidth(Alignment.Start)

        )
        Text(
            text = "$${game.price} MXN",
            color = GreenDollar,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.End)
                .padding(end = 4.dp)
            ,
            textAlign = TextAlign.End

        )
    }
}

@Composable
fun TopSpacer(size: Dp = 4.dp) {
    Spacer(modifier = Modifier.padding(top = size))
}


@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    ListaJuegosTheme {
        Column(modifier = Modifier.fillMaxSize()) {
          //  GameCard()
        }

    }
}