package com.example.habbitsappcorse24.authentication.domain.usecase

class ValidatePaswordUseCase{
    operator fun invoke (password : String) : PassworResult{
        if (password.length < 8 ){
            return PassworResult.Invalid("La contraseña tiene que tener al menos 8 caracteres")
        }
        if (!password.any { it.isLowerCase() }) {
            return PassworResult.Invalid("La contraseña tiene que tener al menos 1 caracteres en minuscula")
        }
        if (!password.any { it.isUpperCase() }) {
            return PassworResult.Invalid("La contraseña tiene que tener al menos 1 caracteres en mayuscula")
        }
        if (!password.any { it.isDigit() }) {
            return PassworResult.Invalid("La contraseña tiene que tener al menos 1 numero")
        }
        return PassworResult.Valid
    }
}
sealed class PassworResult(){
    object Valid : PassworResult()
    data class  Invalid ( val errorMessage : String): PassworResult()

}