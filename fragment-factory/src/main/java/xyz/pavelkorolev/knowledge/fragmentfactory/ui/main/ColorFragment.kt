package xyz.pavelkorolev.knowledge.fragmentfactory.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_color.*
import xyz.pavelkorolev.knowledge.fragmentfactory.R
import xyz.pavelkorolev.knowledge.fragmentfactory.services.ColorService
import javax.inject.Inject

class ColorFragment @Inject constructor(
    private val service: ColorService
) : Fragment(R.layout.fragment_color) {

    companion object {

        const val COLOR = "color"

        fun argumentsOf(@ColorInt color: Int) = bundleOf(
            COLOR to color
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments ?: return

        val color = arguments.getInt(COLOR)
        val darkerColor = service.darker(color)
        colorView.setBackgroundColor(darkerColor)
    }

}
