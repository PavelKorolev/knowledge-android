package xyz.pavelkorolev.knowledge.core

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes resId: Int): String

    fun getStringArray(@ArrayRes resId: Int): Array<String>

}

class ResourceProviderImpl(
    application: Context
) : ResourceProvider {

    private val resources = application.resources

    override fun getString(resId: Int): String = resources.getString(resId)

    override fun getStringArray(resId: Int): Array<String> = resources.getStringArray(resId)

}
