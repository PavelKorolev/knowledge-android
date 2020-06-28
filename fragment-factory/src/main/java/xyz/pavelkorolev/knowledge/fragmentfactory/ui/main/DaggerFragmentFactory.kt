package xyz.pavelkorolev.knowledge.fragmentfactory.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

class DaggerFragmentFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)

        val provider = providers[fragmentClass]
        if (provider != null) {
            return provider.get()
        }

        return super.instantiate(classLoader, className)
    }

}
