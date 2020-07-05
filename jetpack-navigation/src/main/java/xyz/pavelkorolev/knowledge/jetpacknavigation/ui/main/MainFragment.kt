package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import xyz.pavelkorolev.knowledge.jetpacknavigation.App
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.ui.color.ColorFragmentArgs
import xyz.pavelkorolev.knowledge.jetpacknavigation.utils.navigateSafe

class MainFragment : Fragment(R.layout.fragment_main) {

    private val authService by lazy { App.get(this).authService }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        redButton.setOnClickListener { openColorFragment(Color.RED) }
        greenButton.setOnClickListener { openColorFragment(Color.GREEN) }
        blueButton.setOnClickListener { openColorFragment(Color.BLUE) }

        logoutButton.setOnClickListener {
            logout()
        }
    }

    private fun openColorFragment(@ColorInt color: Int) {
        val args = ColorFragmentArgs(color)
        findNavController().navigateSafe(R.id.action_mainFragment_to_colorFragment, args.toBundle())
    }

    private fun logout() {
        authService.setAuthorized(false)
        findNavController().navigateSafe(R.id.action_global_logout)
    }

}
