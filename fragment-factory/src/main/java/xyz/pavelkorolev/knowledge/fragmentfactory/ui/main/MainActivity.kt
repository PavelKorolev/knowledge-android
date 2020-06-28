package xyz.pavelkorolev.knowledge.fragmentfactory.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import xyz.pavelkorolev.knowledge.fragmentfactory.App

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val factory = (application as App).component.fragmentFactory()
        supportFragmentManager.fragmentFactory = factory
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) return
        supportFragmentManager.commit {
            add(android.R.id.content, MainFragment::class.java, null)
            addToBackStack(null)
        }
    }

}
