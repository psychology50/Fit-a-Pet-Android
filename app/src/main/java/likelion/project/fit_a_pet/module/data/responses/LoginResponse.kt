package likelion.project.fit_a_pet.module.data.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("access")
    val access: String,
    @SerializedName("refresh")
    val refresh: String
) : Parcelable
