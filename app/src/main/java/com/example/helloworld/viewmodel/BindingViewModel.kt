package com.example.helloworld.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.model.Player
import com.example.helloworld.model.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BindingViewModel(private val repository: Repository): ViewModel() {
    // LiveData é um dado vivo - que se escuta qualquer mudança
    val playerLiveData = MutableLiveData<List<Player>>()

    fun getPlayers(){
        playerLiveData.value = repository.getPlayers()
    }

    fun getPlayersUsingThread() {
        repository.getPlayersUsingThread { players ->
            playerLiveData.postValue(players)
        }
    }

    fun getPlayersUsingCoroutines(){
        CoroutineScope(Dispatchers.Main).launch {
            val players = withContext(Dispatchers.Default) {
                repository.getPlayersUsingCoroutines()
            }
            playerLiveData.value = players
        }
    }

    class BindingViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BindingViewModel(repository) as T
        }

    }
}