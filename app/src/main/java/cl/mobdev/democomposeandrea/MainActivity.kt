package cl.mobdev.democomposeandrea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.mobdev.democomposeandrea.navigation.AppNavigation
import cl.mobdev.democomposeandrea.ui.theme.DemoComposeAndreaTheme
import cl.mobdev.democomposeandrea.viewmodel.CourseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CourseViewModel by viewModels()

            DemoComposeAndreaTheme {
                AppNavigation()
                viewModel.callCourseList()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoComposeAndreaTheme {
        AppNavigation()
    }
}