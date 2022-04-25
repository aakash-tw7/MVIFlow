package com.example.mviflow.ui.signin

import com.example.mviflow.redux.Action

sealed class SignInAction: Action {
    data class EmailChanged(val newEmail: String) : SignInAction()
    data class PasswordChanged(val newPassword: String) : SignInAction()
    object SignInButtonClicked : SignInAction()
    object SignInStarted : SignInAction()
    object SignInCompleted : SignInAction()
    data class SignInFailed(val error: Throwable?) : SignInAction()
    object InvalidEmailSubmitted : SignInAction()
}