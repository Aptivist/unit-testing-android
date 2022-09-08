package com.aptivist.testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `If any of parameters are empty, should return false`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "",
           "12345678",
            repeatPassword = "12345678"
       )
        assertThat(response).isFalse()
    }

    @Test
    fun `If password and repeat password doesn't match, should be false`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "Sergio123",
           "12345678",
            repeatPassword = "87654321"
       )
        assertThat(response).isFalse()
    }

    @Test
    fun `If username is already registered should be false`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "Diego12345",
           "12345678",
            repeatPassword = "12345678"
       )
        assertThat(response).isFalse()
    }

    @Test
    fun `If username is less than 8 characters should be false`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "Daniel",
           "12345678",
            repeatPassword = "12345678"
       )
        assertThat(response).isFalse()
    }

    @Test
    fun `If password is less than 8 characters should be false`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "Sergio123",
           "1234567",
            repeatPassword = "1234567"
       )
        assertThat(response).isFalse()
    }

    @Test
    fun `If username is complaint, passwords are complaint and passwords match should be true`() {
       val response = RegistrationUtils.validateRegistrationForm(
           "Sergio123",
           "12345678",
            repeatPassword = "12345678"
       )
        assertThat(response).isTrue()
    }
}