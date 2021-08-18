package com.example.helloworld.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.model.Player
import com.example.helloworld.model.Repository
import com.example.helloworld.viewmodel.BindingViewModel

class BindingActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BindingViewModel
    lateinit var buttonChangePlayer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonChangePlayer = findViewById(R.id.botao_entrar)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, BindingViewModel.BindingViewModelFactory(Repository()))
            .get(BindingViewModel::class.java)


    }

    override fun onResume() {
        super.onResume()
        // Aciona a funcao que atualiza o observavel no BingingViewModel
//        viewModel.getPlayersUsingThread()

        // Observe as mudanças
        viewModel.playerLiveData.observe(this, Observer {  players ->
            binding.player = players[2]
        })

//        viewModel.getPlayersUsingThread()
        viewModel.getPlayersUsingCoroutines()
    }

}