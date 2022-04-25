package com.example.mviflow.ui.signin

import android.util.Log
import com.example.mviflow.redux.Reducer

class SignInReducer : Reducer<SignInViewState, SignInAction> {

    override fun reduce(currentState: SignInViewState, action: SignInAction): SignInViewState {
        Log.d("Reducing.... ", action.toString())

        return when (action) {

            is SignInAction.EmailChanged -> {
                currentState.copy(email = action.newEmail)
            }

            is SignInAction.PasswordChanged -> {
                currentState.copy(password = action.newPassword)
            }

            is SignInAction.SignInFailed -> {
                currentState.copy(showProgressBar = false)
            }

            is SignInAction.SignInStarted -> {
                currentState.copy(showProgressBar = true)
            }

            else -> currentState
        }
    }

}