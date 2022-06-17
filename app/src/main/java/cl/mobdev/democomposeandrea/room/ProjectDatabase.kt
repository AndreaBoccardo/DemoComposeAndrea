package cl.mobdev.democomposeandrea.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.mobdev.democomposeandrea.dao.CourseDetailDao
import cl.mobdev.democomposeandrea.dao.CourseItemDao
import cl.mobdev.democomposeandrea.model.CourseDetail
import cl.mobdev.democomposeandrea.model.CourseListItem

@Database(entities = [CourseListItem::class, CourseDetail::class], version = 1)
abstract class ProjectDatabase: RoomDatabase() {

    abstract fun courseDetailDao(): CourseDetailDao
    abstract fun courseItemDao(): CourseItemDao

    companion object{
        @Volatile
        private var instance:ProjectDatabase? = null

        fun getInstance(context: Context) : ProjectDatabase
        {
            if(instance == null)
            {
                synchronized(this)
                {
                    instance = Room.databaseBuilder(context,
                        ProjectDatabase::class.java,
                        "project_db")
                        .build()
                }
            }
            return instance!!
        }
    }

}