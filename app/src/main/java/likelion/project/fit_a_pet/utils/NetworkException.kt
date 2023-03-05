package likelion.project.fit_a_pet.utils

import java.io.IOException

class NetworkException(val code: Int, override val message: String?): IOException(message) {
    override fun toString(): String {
        return "NetworkException(code=$code, message=$message)"
    }
}