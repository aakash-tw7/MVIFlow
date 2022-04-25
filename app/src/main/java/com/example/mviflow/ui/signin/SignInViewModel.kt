package com.example.mviflow.ui.signin

import androidx.lifecycle.ViewModel
import com.example.mviflow.redux.Store
import kotlinx.coroutines.flow.StateFlow

class SignInViewModel: ViewModel() {

    private val store = Store(
        initialState = SignInViewState(),
        reducer = SignInReducer()
    )

    val viewState: StateFlow<SignInViewState> = store.state

    fun emailChanged(newEmail: String) {
        val action = SignInAction.EmailChanged(newEmail)
        store.dispatch(action)
    }

    fun passwordChanged(newPassword: String) {
        val action = SignInAction.PasswordChanged(newPassword)
        store.dispatch(action)
    }

    fun signInClicked() {
        val action = SignInAction.SignInButtonClicked
        store.dispatch(action)
    }

}