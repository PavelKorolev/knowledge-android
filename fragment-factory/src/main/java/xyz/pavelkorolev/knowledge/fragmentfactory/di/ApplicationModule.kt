package xyz.pavelkorolev.knowledge.fragmentfactory.di

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import xyz.pavelkorolev.knowledge.fragmentfactory.ui.main.DaggerFragmentFactory

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindFragmentFactory(factory: DaggerFragmentFactory): FragmentFactory

}
