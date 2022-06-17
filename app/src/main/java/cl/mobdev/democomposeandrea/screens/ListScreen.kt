package cl.mobdev.democomposeandrea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.mobdev.democomposeandrea.model.CourseList
import cl.mobdev.democomposeandrea.model.CourseListItem
import cl.mobdev.democomposeandrea.viewmodel.CourseViewModel
import coil.compose.AsyncImage

@Composable
fun ListScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Text(text = "Course List")
        }
    }) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    val viewModel: CourseViewModel = viewModel()
    val item = viewModel.listItem.value
    LazyColumn(){

    }
}

@Composable
fun MyItem(course:CourseListItem){

     Row() {
         AsyncImage(model = course.image, contentDescription = "")
         Text(course.title!!)
     }
}