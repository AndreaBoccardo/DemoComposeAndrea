package cl.mobdev.democomposeandrea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.mobdev.democomposeandrea.screens.DetailScreen
import cl.mobdev.democomposeandrea.screens.ListScreen


@Composable
fun AppNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.ListScreen.route){
        composable(route = AppScreens.ListScreen.route){
            ListScreen(navController)
        }
        composable(route = AppScreens.DetailScreen.route){
            DetailScreen(navController)
        }
    }

}