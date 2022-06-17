package cl.mobdev.democomposeandrea.service

import cl.mobdev.democomposeandrea.model.CourseDetail
import cl.mobdev.democomposeandrea.model.CourseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseService {

    @GET("courses")
    fun getCourseList(): Call<CourseList>

    @GET("courses_details/{id}")
    fun getCourseDetail(@Path("id") id: String): Call<CourseDetail>

}