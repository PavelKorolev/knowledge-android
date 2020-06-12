package xyz.pavelkorolev.knowledge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import xyz.pavelkorolev.knowledge.R
import xyz.pavelkorolev.knowledge.core.ResourceProviderImpl
import xyz.pavelkorolev.knowledge.service.EightBallService
import xyz.pavelkorolev.knowledge.service.EightBallServiceImpl

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val eightBallService: EightBallService by lazy {
        EightBallServiceImpl(ResourceProviderImpl(application))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = eightBallService.giveAnswer()
        }
    }

}
