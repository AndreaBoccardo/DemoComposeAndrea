package cl.mobdev.democomposeandrea.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.mobdev.democomposeandrea.model.CourseList
import cl.mobdev.democomposeandrea.model.CourseListItem
import cl.mobdev.democomposeandrea.room.ProjectDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseItemRepository(var context: Context) {

    private val db = ProjectDatabase.getInstance(context)

    fun addCourseList(listCourses: CourseList){
        CoroutineScope(Dispatchers.IO).launch {
            db.courseItemDao().addCourseList(listCourses)
        }
    }

    fun toListCourses(): LiveData<List<CourseListItem>>{
        return db.courseItemDao().toListCourses()
    }

}