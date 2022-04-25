package com.example.mviflow.ui.signin

import com.example.mviflow.redux.State

/**
 * An implementation of [State] that describes the configuration of the login screen at a given time.
 */
data class SignInViewState(
    val email: String = "",
    val password: String = "",
    val showProgressBar: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
) : State