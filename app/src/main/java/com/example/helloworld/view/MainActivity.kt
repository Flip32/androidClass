package com.example.helloworld.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.helloworld.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var rootView: View

    var pressedBackButtonTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_relative)
        setContentView(R.layout.activity_constraint)

        rootView = findViewById<ConstraintLayout>(R.id.root)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this, "exibindo o tost", Toast.LENGTH_LONG).show()
        val snackbar = Snackbar.make(rootView, "Texto do snackbar",Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){
//            it.
        }
        snackbar.setTextColor(ContextCompat.getColor(this, R.color.white))

        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.teal_700))

        findViewById<Button>(R.id.botao_entrar).setOnClickListener(View.OnClickListener { _ ->
            snackbar.show()
        })
    }

    override fun onBackPressed() {
        if(pressedBackButtonTimes == 0) {
            pressedBackButtonTimes++
            Toast.makeText(this, "Aperte novamente para sair do app", Toast.LENGTH_SHORT)
        } else {
            super.onBackPressed()
        }

    }
}