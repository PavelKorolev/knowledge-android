package xyz.pavelkorolev.knowledge.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import xyz.pavelkorolev.knowledge.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            viewModel.onButtonClick()
        }

        viewModel.listener = object : MainListener {
            override fun onAnswerUpdate(answer: String?) {
                textView.text = answer
            }
        }

        viewModel.restore()
    }

}
