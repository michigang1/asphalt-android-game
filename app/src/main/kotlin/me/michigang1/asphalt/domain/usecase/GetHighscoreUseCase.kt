package me.michigang1.asphalt.domain.usecase

import me.michigang1.asphalt.domain.repo.HighscoreRepository
import kotlinx.coroutines.flow.Flow

class GetHighscoreUseCase(
    private val highscoreRepository: HighscoreRepository,
) {
    fun execute(): Flow<Int> = highscoreRepository.getHighScore()
}