package xyz.pavelkorolev.knowledge.fragmentfactory

import android.app.Application
import xyz.pavelkorolev.knowledge.fragmentfactory.di.ApplicationComponent
import xyz.pavelkorolev.knowledge.fragmentfactory.di.DaggerApplicationComponent

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

}
