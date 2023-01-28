package likelion.project.fit_a_pet.network.data.requests

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// 요청 데이터
@Parcelize
data class LoginRequest(
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
) : Parcelable
