package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_auth.*
import xyz.pavelkorolev.knowledge.jetpacknavigation.App
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.utils.navigateSafe

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private val authService by lazy { App.get(this).authService }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authButton.setOnClickListener {
            authService.setAuthorized(true)
            findNavController().navigateSafe(R.id.action_authFragment_to_mainFragment)
        }
        registerButton.setOnClickListener {
            findNavController().navigateSafe(R.id.action_authFragment_to_registrationNavGraph)
        }
    }

}
