package cl.mobdev.democomposeandrea.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.mobdev.democomposeandrea.viewmodel.CourseViewModel
import coil.compose.AsyncImage

@Composable
fun DetailScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack,"Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Course Details")
        }
    }) {
        SecondBodyContent(navController)
    }
}

@Composable
fun SecondBodyContent(navController: NavController){
    val viewModel: CourseViewModel = viewModel()
    val course = viewModel.course.value

    Column() {
        if (course != null) {
            AsyncImage(model = course.image, contentDescription = "")
            Text(course.title!!, style = MaterialTheme.typography.h1)
            Text(course.description!!, style = MaterialTheme.typography.h2)
            Text(course.start!!, style = MaterialTheme.typography.h3)
        }

    }

}
