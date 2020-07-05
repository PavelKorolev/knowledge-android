package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.registration

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_registration_license.*
import xyz.pavelkorolev.knowledge.jetpacknavigation.App
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.utils.navigateSafe

class RegistrationLicenseFragment : Fragment(R.layout.fragment_registration_license) {

    private val viewModel: RegistrationViewModel by navGraphViewModels(
        R.id.nav_graph_registration
    )

    private val authService by lazy {
        App.get(this).authService
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            onNextClicked()
        }
    }

    private fun onNextClicked() {
        if (!viewModel.isOk()) return
        if (!acceptCheckBox.isChecked) return

        authService.setAuthorized(true)
        findNavController().navigateSafe(R.id.action_global_mainFragment)

        val message = getString(R.string.welcome, viewModel.name)
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}
