package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import xyz.pavelkorolev.knowledge.jetpacknavigation.App
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.utils.navigateSafe

class SplashFragment : Fragment() {

    private val authService by lazy { App.get(this).authService }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val actionId = when (authService.isAuthorized()) {
            true -> R.id.action_splashFragment_to_mainFragment
            false -> R.id.action_splashFragment_to_authFragment
        }
        findNavController().navigateSafe(actionId)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
