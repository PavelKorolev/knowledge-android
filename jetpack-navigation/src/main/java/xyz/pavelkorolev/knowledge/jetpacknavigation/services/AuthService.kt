package xyz.pavelkorolev.knowledge.jetpacknavigation.services

import android.app.Application
import android.content.Context
import androidx.core.content.edit

class AuthService(
    application: Application
) {

    companion object {
        private const val TITLE = "auth"
        private const val AUTH_KEY = "auth_key"
    }

    private val storage = application.getSharedPreferences(TITLE, Context.MODE_PRIVATE)

    fun setAuthorized(isAuthorized: Boolean) = storage.edit {
        putBoolean(AUTH_KEY, isAuthorized)
    }

    fun isAuthorized() = storage.getBoolean(AUTH_KEY, false)

}
