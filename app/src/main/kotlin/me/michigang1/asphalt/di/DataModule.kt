package me.michigang1.asphalt.di

import android.content.Context
import me.michigang1.asphalt.data.repo.HighscoreRepositoryImpl
import me.michigang1.asphalt.data.source.highscoreDataStore
import me.michigang1.asphalt.domain.repo.HighscoreRepository
import com.example.racingcar.utils.SoundRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesHighscoreRepository(
        @ApplicationContext context: Context
    ): HighscoreRepository {
        return HighscoreRepositoryImpl(context.highscoreDataStore)
    }

    @Provides
    @Singleton
    fun providesSoundManager(
        @ApplicationContext context: Context
    ): SoundRepository {
        return SoundRepository(context)
    }


}