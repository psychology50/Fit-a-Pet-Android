package likelion.project.fit_a_pet.module.data.responses

import com.google.gson.annotations.SerializedName
import likelion.project.fit_a_pet.model.domain.User

data class RegisterResponse(
    @SerializedName("User")
    val user: User
)
