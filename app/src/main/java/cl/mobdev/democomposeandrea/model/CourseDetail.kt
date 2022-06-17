package cl.mobdev.democomposeandrea.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "course_detail")
data class CourseDetail(

	@field:SerializedName("image")
	val image: String?,

	@field:SerializedName("weeks")
	val weeks: Int?,

	@field:SerializedName("modality")
	val modality: String?,

	@field:SerializedName("start")
	val start: String?,

	@field:SerializedName("description")
	val description: String?,

	@field:SerializedName("scholarshipsAvailable")
	val scholarshipsAvailable: Boolean?,

	@field:SerializedName("id")
	@PrimaryKey val id: String,

	@field:SerializedName("tuition")
	val tuition: String?,

	@field:SerializedName("title")
	val title: String?,

	@field:SerializedName("minimumSkill")
	val minimumSkill: String?
)