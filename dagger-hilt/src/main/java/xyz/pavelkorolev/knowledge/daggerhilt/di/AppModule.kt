package xyz.pavelkorolev.knowledge.daggerhilt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import xyz.pavelkorolev.knowledge.core.ResourceProvider
import xyz.pavelkorolev.knowledge.core.ResourceProviderImpl

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Provides
    fun provideResourcesProvider(
        @ApplicationContext context: Context
    ): ResourceProvider = ResourceProviderImpl(context)

}
