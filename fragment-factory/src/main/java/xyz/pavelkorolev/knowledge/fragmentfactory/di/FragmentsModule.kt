package xyz.pavelkorolev.knowledge.fragmentfactory.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import xyz.pavelkorolev.knowledge.fragmentfactory.ui.main.ColorFragment
import xyz.pavelkorolev.knowledge.fragmentfactory.ui.main.MainFragment

@Module
abstract class FragmentsModule {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun mainFragment(fragment: MainFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ColorFragment::class)
    abstract fun colorFragment(fragment: ColorFragment): Fragment

}
