package xyz.pavelkorolev.knowledge.coroutinesflow.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import kotlinx.coroutines.FlowPreview
import xyz.pavelkorolev.knowledge.coroutinesflow.R

class MainFragment : Fragment(R.layout.fragment_main) {

    @FlowPreview
    private val viewModel: MainViewModel by viewModels()

    @FlowPreview
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner) {
            Log.d("VIEW_COROUTINES_EVENTS", it)
        }
    }

}
