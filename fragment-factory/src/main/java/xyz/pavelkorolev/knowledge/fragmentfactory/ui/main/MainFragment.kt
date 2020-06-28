package xyz.pavelkorolev.knowledge.fragmentfactory.ui.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.fragment_main.*
import xyz.pavelkorolev.knowledge.fragmentfactory.R
import xyz.pavelkorolev.knowledge.fragmentfactory.ui.color.ColorFragment
import javax.inject.Inject

class MainFragment @Inject constructor() : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        redButton.setOnClickListener { openColorFragment(Color.RED) }
        greenButton.setOnClickListener { openColorFragment(Color.GREEN) }
        blueButton.setOnClickListener { openColorFragment(Color.BLUE) }
    }

    private fun openColorFragment(@ColorInt color: Int) {
        val fragmentManager = activity?.supportFragmentManager ?: return

        fragmentManager.commit {
            val args = ColorFragment.argumentsOf(color)
            add(android.R.id.content, ColorFragment::class.java, args)
            addToBackStack(null)
        }
    }

}
