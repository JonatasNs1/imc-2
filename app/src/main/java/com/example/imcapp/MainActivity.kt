package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // remover a toolbar
      supportActionBar!!.hide()

        //instanciar o botao entrar, findViewById<>() - encontrar uma view pelo o id
        val botaoCriarConta = findViewById<Button>(R.id.buton_criar_conta)

        //criar um listener - ouvinte, android fica de olho nesse botao (click)
        botaoCriarConta.setOnClickListener {
            //criar uma intent(), intent precisa de dois parametros, a intent v activiny que está tendo a intent
            val abrirCadastro = Intent(this, Cadastro::class.java)
            startActivity(abrirCadastro)
        }
    }


}