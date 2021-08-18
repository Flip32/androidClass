package com.example.helloworld.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Repository {
    fun getPlayers(): List<Player> {
        return listOf(
            Player(1, "Jogador 1"),
            Player(2, "Jogador 2"),
            Player(3, "Jogador 3"),
            Player(4, "Jogador 4"),
        )
    }

    fun getPlayersUsingThread(callback: (players: List<Player>) -> Unit){
        Thread {
            Thread.sleep(3000)
            callback.invoke( getPlayers() )
        }.start()
    }

    suspend fun getPlayersUsingCoroutines(): List<Player> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            getPlayers()
        }
    }
}