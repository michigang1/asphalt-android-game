package me.michigang1.asphalt.di

import me.michigang1.asphalt.domain.repo.HighscoreRepository
import me.michigang1.asphalt.domain.usecase.GetHighscoreUseCase
import me.michigang1.asphalt.domain.usecase.SaveHighscoreUseCase
import com.example.racingcar.utils.SoundRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesGetHighscoreUseCase(
        highscoreRepository: HighscoreRepository
    ): GetHighscoreUseCase {
        return GetHighscoreUseCase(highscoreRepository)
    }

    @Provides
    @Singleton
    fun providesSaveHighscoreUseCase(
        highscoreRepository: HighscoreRepository,
        soundRepository: SoundRepository,
    ): SaveHighscoreUseCase {
        return SaveHighscoreUseCase(highscoreRepository, soundRepository)
    }
}