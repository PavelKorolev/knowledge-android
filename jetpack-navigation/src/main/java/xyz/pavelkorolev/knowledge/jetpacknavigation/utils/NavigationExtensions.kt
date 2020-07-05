package xyz.pavelkorolev.knowledge.jetpacknavigation.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions

/**
 * We need to create extension to create default animations.
 * We need to create extension to avoid crash https://issuetracker.google.com/issues/118975714
 */
fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null
) {
    if (currentDestination?.id == resId) return
    navigate(resId, args, navOptions)
}
