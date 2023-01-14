package likelion.project.fit_a_pet.repository

import likelion.project.fit_a_pet.module.data.responses.LoginResponse

class LoginState (
    var isLoading: Boolean = false,
    var data: LoginResponse? = null,
    var error: String = ""
)