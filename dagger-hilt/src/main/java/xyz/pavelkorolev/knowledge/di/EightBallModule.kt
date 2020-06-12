package xyz.pavelkorolev.knowledge.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import xyz.pavelkorolev.knowledge.service.EightBallService
import xyz.pavelkorolev.knowledge.service.EightBallServiceImpl

@InstallIn(ApplicationComponent::class)
@Module
abstract class EightBallModule {

    @Binds
    abstract fun bindService(impl: EightBallServiceImpl): EightBallService

}
