package cl.mobdev.democomposeandrea.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "course_list")
data class CourseListItem(

	@field:SerializedName("image")
	val image: String?,

	@field:SerializedName("weeks")
	val weeks: Int?,

	@field:SerializedName("previewDescription")
	val previewDescription: String?,

	@field:SerializedName("start")
	val start: String?,

	@field:SerializedName("id")
	@PrimaryKey val id: String,

	@field:SerializedName("title")
	val title: String?
)