package cl.mobdev.democomposeandrea.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cl.mobdev.democomposeandrea.model.CourseDetail

@Dao
interface CourseDetailDao {

    @Insert(onConflict = REPLACE)
    fun addCourseDetail(courseDetail: CourseDetail)

    @Query("select image, weeks, modality, start, description, scholarshipsAvailable, id, " +
            "tuition, title, minimumSkill from course_detail")
    fun toListCouseDetail(): LiveData<List<CourseDetail>>

    @Query("select image, weeks, modality, start, description, scholarshipsAvailable, id, " +
            "tuition, title, minimumSkill from course_detail where id = :id")
    fun findCourseDetail(id: String): CourseDetail

}