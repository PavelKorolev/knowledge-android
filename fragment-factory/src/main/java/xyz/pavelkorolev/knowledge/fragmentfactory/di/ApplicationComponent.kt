package xyz.pavelkorolev.knowledge.fragmentfactory.di

import androidx.fragment.app.FragmentFactory
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class,
        FragmentsModule::class
    ]
)
interface ApplicationComponent {

    fun fragmentFactory(): FragmentFactory

}
