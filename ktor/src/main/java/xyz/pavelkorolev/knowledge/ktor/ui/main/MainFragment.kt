package xyz.pavelkorolev.knowledge.ktor.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import xyz.pavelkorolev.knowledge.ktor.R
import xyz.pavelkorolev.knowledge.ktor.ui.data.ApiProvider
import xyz.pavelkorolev.knowledge.ktor.ui.data.CatApi

class MainFragment : Fragment(R.layout.fragment_main) {

    private val apiProvider = ApiProvider()
    private val api: CatApi = apiProvider.catApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshButton.setOnClickListener {
            load()
        }
        load()
    }

    private fun load() {
        GlobalScope.launch(Dispatchers.Main) {
            progressBar.isVisible = true
            val response = api.getFact()
            progressBar.isVisible = false
            responseTextView.text = response
        }
    }

}
