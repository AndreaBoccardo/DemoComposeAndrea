package cl.mobdev.democomposeandrea.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.mobdev.democomposeandrea.model.CourseDetail
import cl.mobdev.democomposeandrea.room.ProjectDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseDetailRepository(var context: Context) {

    private val db = ProjectDatabase.getInstance(context)

    fun addCourseDetail(courseDetail: CourseDetail){
        CoroutineScope(Dispatchers.IO).launch {
            db.courseDetailDao().addCourseDetail(courseDetail)
        }
    }

    fun toListCouseDetail(): LiveData<List<CourseDetail>>{
        return db.courseDetailDao().toListCouseDetail()
    }

    fun findCourseDetail(id: String): CourseDetail{
        return db.courseDetailDao().findCourseDetail(id)
    }

}