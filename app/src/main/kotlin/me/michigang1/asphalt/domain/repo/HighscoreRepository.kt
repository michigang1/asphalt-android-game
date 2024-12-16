package me.michigang1.asphalt.domain.repo

import kotlinx.coroutines.flow.Flow

interface HighscoreRepository {

    suspend fun saveHighScore(score: Int)

    fun getHighScore(): Flow<Int>
}