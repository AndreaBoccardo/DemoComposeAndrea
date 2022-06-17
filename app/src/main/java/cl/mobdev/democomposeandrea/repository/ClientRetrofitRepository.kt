package cl.mobdev.democomposeandrea.repository

import cl.mobdev.democomposeandrea.client.ClientRetrofit
import cl.mobdev.democomposeandrea.model.CourseDetail
import cl.mobdev.democomposeandrea.model.CourseList
import retrofit2.Call

class ClientRetrofitRepository {

    private val client = ClientRetrofit.getInstance(ClientRetrofit.base_url)

    fun getListCourse(): Call<CourseList>{
        return client.getCourseList()
    }

    fun getDetailCourse(id: String): Call<CourseDetail>{
        return client.getCourseDetail(id)
    }

}