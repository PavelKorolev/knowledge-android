package xyz.pavelkorolev.knowledge.fragmentfactory.di

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindFragmentFactory(factory: DaggerFragmentFactory): FragmentFactory

}
