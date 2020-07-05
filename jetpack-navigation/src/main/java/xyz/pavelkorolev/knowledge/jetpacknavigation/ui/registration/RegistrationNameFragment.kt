package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_registration_name.*
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.utils.navigateSafe

class RegistrationNameFragment : Fragment(R.layout.fragment_registration_name) {

    private val viewModel: RegistrationViewModel by navGraphViewModels(
        R.id.nav_graph_registration
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextButton.setOnClickListener {
            onNextClicked()
        }
    }

    private fun onNextClicked() {
        val text = nameEditText.text?.toString() ?: return

        val name = text.trim()
        if (name.isEmpty()) return

        viewModel.name = name
        findNavController().navigateSafe(R.id.action_registrationNameFragment_to_registrationLicenseFragment)
    }

}
