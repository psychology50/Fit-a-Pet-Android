package likelion.project.fit_a_pet.module.data.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String
)
