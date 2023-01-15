package likelion.project.fit_a_pet.model.repository

import likelion.project.fit_a_pet.module.data.responses.RegisterResponse

class RegisterState (
    var isLoading: Boolean = false,
    var data: RegisterResponse? = null,
    var error: String = ""
    )