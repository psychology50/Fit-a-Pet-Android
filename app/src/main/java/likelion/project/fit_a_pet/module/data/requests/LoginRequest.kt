package likelion.project.fit_a_pet.module.data.requests

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest(
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
) : Parcelable
