package cl.mobdev.democomposeandrea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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

/*        items(item!!.size){course ->
            MyItem(course)
        }*/
    }
}

@Composable
fun MyItem(course:CourseListItem){
     Row(
         modifier = Modifier
             .background(MaterialTheme.colors.background)
             .padding(8.dp)
     ) {
         AsyncImage(model = course.image, contentDescription = "")
         Text(
             course.title!!,
             style = MaterialTheme.typography.h3
         )
     }
}