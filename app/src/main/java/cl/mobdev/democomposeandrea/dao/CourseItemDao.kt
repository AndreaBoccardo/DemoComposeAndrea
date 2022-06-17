package cl.mobdev.democomposeandrea.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cl.mobdev.democomposeandrea.model.CourseList
import cl.mobdev.democomposeandrea.model.CourseListItem

@Dao
interface CourseItemDao {

    @Insert(onConflict = REPLACE)
    fun addCourseList(listCourses: CourseList)

    @Query("select image, weeks, previewDescription, start, id, title from course_list")
    fun toListCourses(): LiveData<List<CourseListItem>>

}