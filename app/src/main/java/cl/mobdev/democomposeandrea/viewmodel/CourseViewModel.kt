package cl.mobdev.democomposeandrea.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cl.mobdev.democomposeandrea.model.CourseDetail
import cl.mobdev.democomposeandrea.model.CourseList
import cl.mobdev.democomposeandrea.repository.ClientRetrofitRepository
import cl.mobdev.democomposeandrea.repository.CourseDetailRepository
import cl.mobdev.democomposeandrea.repository.CourseItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseViewModel(application: Application) : AndroidViewModel(application) {

    private val clientRepo = ClientRetrofitRepository()
    private val courseItemRepo = CourseItemRepository(application)
    private val courseDetailRepo = CourseDetailRepository(application)

    private val log = "ERROR_CALL"
    var id = MutableLiveData<String>()

    val listItem = courseItemRepo.toListCourses()
    val listDetail = courseDetailRepo.toListCouseDetail()
    val course: MutableLiveData<CourseDetail> = MutableLiveData()

    fun callCourseList(){
        clientRepo.getListCourse().enqueue(object : Callback<CourseList>{
            override fun onResponse(call: Call<CourseList>, response: Response<CourseList>) {
                response.body().let {
                    courseItemRepo.addCourseList(it!!)
                }
            }

            override fun onFailure(call: Call<CourseList>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })
    }

    fun callCourseDetail(id: String){
        clientRepo.getDetailCourse(id).enqueue(object : Callback<CourseDetail>{
            override fun onResponse(call: Call<CourseDetail>, response: Response<CourseDetail>) {
                response.body().let {
                    courseDetailRepo.addCourseDetail(it!!)
                }
            }

            override fun onFailure(call: Call<CourseDetail>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })
    }

    fun findCourses(){
        CoroutineScope(Dispatchers.IO).launch {
            course.postValue(courseDetailRepo.findCourseDetail(id.value!!))
        }
    }

}