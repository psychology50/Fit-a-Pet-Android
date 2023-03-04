package likelion.project.fit_a_pet.model.repository

import likelion.project.fit_a_pet.network.data.responses.LoginResponse
import likelion.project.fit_a_pet.utils.Resource

class LoginState(
    var data: LoginResponse? = null,
    var error: String? = "An error occurred"
)