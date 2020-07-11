package xyz.pavelkorolev.knowledge.coroutinesflow.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) return
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, MainFragment())
            .addToBackStack(null)
            .commit()
    }

}
