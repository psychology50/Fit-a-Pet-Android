package likelion.project.fit_a_pet.module.data.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access")
    val access: String,
    @SerializedName("refresh")
    val refresh: String
)
