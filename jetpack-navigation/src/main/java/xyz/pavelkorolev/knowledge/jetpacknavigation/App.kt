package xyz.pavelkorolev.knowledge.jetpacknavigation

import android.app.Application
import androidx.fragment.app.Fragment
import xyz.pavelkorolev.knowledge.jetpacknavigation.services.AuthService

class App : Application() {

    val authService by lazy {
        AuthService(this)
    }

    companion object {

        fun get(fragment: Fragment): App = fragment.activity?.application as App

    }

}
