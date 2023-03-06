package likelion.project.fit_a_pet.model.repository

import likelion.project.fit_a_pet.network.data.responses.RegisterResponse

class RegisterState (
    var data: RegisterResponse? = null,
    var error: String? = "An error occurred"
    )