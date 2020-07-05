package xyz.pavelkorolev.knowledge.jetpacknavigation.ui.color

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_color.*
import xyz.pavelkorolev.knowledge.jetpacknavigation.R
import xyz.pavelkorolev.knowledge.jetpacknavigation.services.ColorService

class ColorFragment : Fragment(R.layout.fragment_color) {

    private val safeArgs: ColorFragmentArgs by navArgs()

    private val service: ColorService = ColorService()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val color = safeArgs.color
        val darkerColor = service.darker(color)
        colorView.setBackgroundColor(darkerColor)
    }

}
