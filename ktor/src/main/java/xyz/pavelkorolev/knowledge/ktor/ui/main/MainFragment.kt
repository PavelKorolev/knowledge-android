package xyz.pavelkorolev.knowledge.ktor.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import xyz.pavelkorolev.knowledge.ktor.BuildConfig
import xyz.pavelkorolev.knowledge.ktor.R
import xyz.pavelkorolev.knowledge.ktor.ui.data.ApiProvider
import xyz.pavelkorolev.knowledge.ktor.ui.data.CatApi
import xyz.pavelkorolev.knowledge.ktor.ui.data.RandomUserApi

class MainFragment : Fragment(R.layout.fragment_main) {

    private val apiProvider = ApiProvider(BuildConfig.DEBUG)
    private val api: CatApi = apiProvider.catApi
    private val userApi: RandomUserApi = apiProvider.randomUserApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sourceRadioGroup.setOnCheckedChangeListener { _, _ ->
            load()
        }

        refreshButton.setOnClickListener {
            load()
        }

        load()
    }

    private fun load() {
        when (sourceRadioGroup.checkedRadioButtonId) {
            R.id.catFactsRadioButton -> loadCatFacts()
            R.id.randomUserRadioButton -> loadRandomUser()
            else -> return
        }
    }

    private val count: Int get() = countSeekBar.progress + 2

    private fun loadCatFacts() {
        GlobalScope.launch(Dispatchers.Main) {
            progressBar.isVisible = true
            val response = api.getFacts(count)
            progressBar.isVisible = false

            val text = response
                .mapNotNull { it.text }
                .joinToString("\n\n")
            responseTextView.text = text
        }
    }

    private fun loadRandomUser() {
        GlobalScope.launch(Dispatchers.Main) {
            progressBar.isVisible = true
            val response = userApi.getUsers(count)
            progressBar.isVisible = false

            val text = response.joinToString("\n\n") {
                "${it.name.first} ${it.name.last}"
            }
            responseTextView.text = text
        }
    }

}
