package me.michigang1.asphalt.domain.usecase

import me.michigang1.asphalt.domain.repo.HighscoreRepository
import me.michigang1.asphalt.ui.viewmodel.MainViewModel
import com.example.racingcar.utils.SoundRepository
import kotlinx.coroutines.flow.first

class SaveHighscoreUseCase(
    private val highscoreRepository: HighscoreRepository,
    private val soundRepository: SoundRepository
) {

    suspend fun execute(score: Int) {
        val currentHighscore = highscoreRepository.getHighScore().first()
        if (score > currentHighscore) {
            highscoreRepository.saveHighScore(score)
            soundRepository.playSound(MainViewModel.NEW_HIGHSCORE_SOUND_ID)
        }
    }
}