package com.example.myandroidproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myandroidproject.ui.theme.Screens.ContactUs.ContactUs
import com.example.myandroidproject.ui.theme.Screens.Home.HomeScreen
import com.example.myandroidproject.ui.theme.Screens.Login.LoginScreen
import com.example.myandroidproject.ui.theme.Screens.OurServices.ItineraryScreen
import com.example.myandroidproject.ui.theme.Screens.Register.RegisterScreen

//import com.example.myandroidproject.ui.theme.Screens.Home.HomePage
//import com.example.myandroidproject.ui.theme.Screens.about.AboutScreen
//import com.example.myandroidproject.ui.theme.Screens.home.HomeScreen
//import com.example.myandroidproject.ui.theme.Screens.login.LoginScreen
//import com.example.myandroidproject.ui.theme.Screens.products.AddProductsScreen
//import com.example.myandroidproject.ui.theme.Screens.products.UpdateProductsScreen
//import com.example.myandroidproject.ui.theme.Screens.products.ViewProductsScreen
//import com.example.myandroidproject.ui.theme.Screens.products.ViewUploadsScreen
//import com.example.myandroidproject.ui.theme.Screens.register.RegisterScreen

@Composable
fun  AppNavHost(modifier: Modifier = Modifier, navController: androidx.navigation.NavHostController =  rememberNavController(), startDestination:String = ROUTE_REGISTER ){
    NavHost(navController = navController, modifier = modifier, startDestination = startDestination) {
        composable(ROUTE_HOMEPAGE) {
            HomeScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
//        composable(ROUTE_OUR_SERVICES){
//            createClickableCard()
//        }
//        composable(ROUTE_ACCOMMODATION){
//            HomePageScreen(navController)
//        }
//        composable(ROUTE_ITINERARY){
//            AddProductsScreen(navController)
//        }
//      composable(ROUTE_ITINERARY){
//          CardView(navController)

//      }

//        }
        composable(ROUTE_CONTACT_US) {
            ContactUs(navController)
        }
        composable(ROUTE_ITINERARY) {
            ItineraryScreen(navController)
        }

    }
}



