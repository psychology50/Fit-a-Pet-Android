package likelion.project.fit_a_pet.model.repository

import likelion.project.fit_a_pet.network.data.responses.LoginResponse

class LoginState (
    var isLoading: Boolean = false,
    var data: LoginResponse? = null,
    var error: String = ""
)