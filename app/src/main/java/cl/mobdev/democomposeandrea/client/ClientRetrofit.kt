package cl.mobdev.democomposeandrea.client

import cl.mobdev.democomposeandrea.service.CourseService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        const val base_url = "https://courses-fake-api.herokuapp.com/"
        private var client: Retrofit? = null

        fun getInstance(url:String) : CourseService
        {
            if(client == null)
            {
                client = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return client!!.create(CourseService::class.java)
        }
    }

}