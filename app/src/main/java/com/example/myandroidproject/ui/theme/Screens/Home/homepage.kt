package com.example.myandroidproject.ui.theme.Screens.Home

//import com.example.myandroidproject.navigation.ROUTE_ADD_NOMINEE
//import com.example.myandroidproject.navigation.ROUTE_OUR_SERVICES
//import android.graphics.Color
//import com.example.myandroidproject.R
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidproject.R
import com.example.myandroidproject.models.CardData
import com.example.myandroidproject.navigation.ROUTE_CONTACT_US
import com.example.myandroidproject.navigation.ROUTE_HOMEPAGE
import com.example.myandroidproject.navigation.ROUTE_OUR_SERVICES
import com.example.myandroidproject.navigation.ROUTE_REGISTER


//import com.example.myandroidproject.navigation.ROUTE_VIEW_NOMINEE
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Box {
//        Image(
//            painter = painterResource(id = R.drawable.homepage),
//            contentDescription = "home page",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .matchParentSize()
//                .mandatorySystemGesturesPadding()
//
//
//        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
//        .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val context = LocalContext.current.applicationContext
            androidx.compose.material3.TopAppBar(title = { Text(text = "DreamBound Adventures") },
                navigationIcon = {


                    IconButton(onClick = { TODO() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "/DreamBound Adventures/"
                        )
//        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                ), actions = {

                    IconButton(onClick = {navController.navigate(ROUTE_HOMEPAGE)
                        Toast.makeText(
                            context,
                            "Home",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = { navController.navigate(ROUTE_OUR_SERVICES)
                        Toast.makeText(
                            context,
                            "Our Services",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {navController.navigate(ROUTE_REGISTER)
                        Toast.makeText(
                            context,
                            "Contact Us",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = "Contact Us",
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {navController.navigate(ROUTE_CONTACT_US)
                        Toast.makeText(
                            context,
                            "My profile",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.Person,
//                            contentDescription = "My profile",
//                            tint = Color.Black
//                        )
                    }
                }
            )

            Text(
                text = "Welcome to DreamBound Adventures",
                color = Color.Blue,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp
            )}
        fun createClickableCard(navController: NavHostController,
                                context: Context, title: String, description: String, onClickListener: (View) -> Unit): View {
            val cardView = CardView(context).apply {
                radius = context.resources.getDimension(R.dimen.card_corner_radius)
                cardElevation = context.resources.getDimension(R.dimen.card_elevation)
                setCardBackgroundColor(android.graphics.Color.WHITE)

            }

            val linearLayout = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(
                    context.resources.getDimensionPixelSize(R.dimen.card_padding),
                    context.resources.getDimensionPixelSize(R.dimen.card_padding),
                    context.resources.getDimensionPixelSize(R.dimen.card_padding),
                    context.resources.getDimensionPixelSize(R.dimen.card_padding)
                )
            }

            val titleTextView = TextView(context).apply {
                setTextAppearance(R.style.TextAppearance_AppCompat_Title)
                text = title
            }

            val descriptionTextView = TextView(context).apply {
                setTextAppearance(R.style.TextAppearance_AppCompat_Body1)
                text = description
            }

            fun createWidgetWithCards(context: Context, onCardClickListener: (View, Int) -> Unit): View {
                val widgetLayout = LinearLayout(context).apply {
                    orientation = LinearLayout.VERTICAL
                }

                val cardData = listOf(
//                    CardData("TRANSPORT", "Description for Card 1", R.drawable.transport),
                    CardData("ACCOMMODATION", "Description for Card 2", R.drawable.hotel),
                    CardData("ITINERARY", "Description for Card 3", R.drawable.itinerary),
//            CardData("Card 4", "Description for Card 4", R.drawable.card4_image)
                )

                // ...


                linearLayout.addView(titleTextView)
                linearLayout.addView(descriptionTextView)
                cardView.addView(linearLayout)

                cardView.setOnClickListener(onClickListener)

                return cardView
            }
            return cardView
        }

        fun createClickableCard(){
            createClickableCard()
        }

    }
}

@Preview
@Composable
fun HomeScreen(){
    HomeScreen(rememberNavController())
}