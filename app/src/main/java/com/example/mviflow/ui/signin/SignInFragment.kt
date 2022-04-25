package com.example.mviflow.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.mviflow.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect

class SignInFragment: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        init()
        observeState()
    }

    private fun init() {

        binding.emailInput.doOnTextChanged { text, _, _, _ ->
            viewModel.emailChanged(newEmail = text?.toString().orEmpty())
        }

        binding.passwordInput.doOnTextChanged { text, _, _, _ ->
            viewModel.passwordChanged(newPassword = text?.toString().orEmpty())
        }

        binding.signInButton.setOnClickListener {
            viewModel.signInClicked()
        }
    }

    private fun observeState() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect {
                binding.progressBar.isVisible = it.showProgressBar
            }
        }
    }
}