package likelion.project.fit_a_pet.model.domain

import com.google.gson.annotations.SerializedName

// API로 부터 받은 데이터로 사용자 객체 생성
data class User(
    @SerializedName("username")
    val username: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("create_dt")
    val create_dt: String,
    @SerializedName("profile_img")
    val profile_img: String
)
