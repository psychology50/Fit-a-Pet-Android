package likelion.project.fit_a_pet.network.data.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// 응답 데이터
@Parcelize
data class LoginResponse(
    @SerializedName("access")
    val access: String,
    @SerializedName("refresh")
    val refresh: String
) : Parcelable
