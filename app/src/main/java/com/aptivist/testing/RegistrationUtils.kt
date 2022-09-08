package com.aptivist.testing

object RegistrationUtils {

    val users = listOf("Diego12345", "Irving12345", "Sergio12345")

    /***
     * This class should:
     * -If any of parameters are empty, should be false
     * -If password and repeat password doesn't match, should be false
     * -If username is already registered should be false
     * -If username is less than 8 characters should be false
     * -If password is less than 8 characters should be false
     * -If username is complaint, passwords are complaint and passwords match should be true
     */
    fun validateRegistrationForm(
        userName : String,
        password : String,
        repeatPassword : String
    ) : Boolean {
        return when {
            userName.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() -> false
            password != repeatPassword -> false
            users.contains(userName) -> false
            userName.length < 8 -> false
            password.length < 8 -> false
            else -> true
        }
    }
}