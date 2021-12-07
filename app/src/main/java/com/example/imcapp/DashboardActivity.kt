package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
        lateinit var textNome: TextView
        lateinit var textProfissao: TextView
        lateinit var textAltura : TextView
        lateinit var cardPesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        textNome = findViewById(R.id.text_nome_dash)
        textProfissao = findViewById(R.id.text_profissao_dash)
        textAltura = findViewById(R.id.text_altura_dash)
        cardPesarAgora = findViewById(R.id.card_pesar_agora)

        cardPesarAgora.setOnClickListener {
            val abrirPesagem = Intent(this,pesagem_activity2::class.java)
            startActivity(abrirPesagem) //para starta a activity, precisa colocar sempre
        }

        // Carregar os dados da sharedPreferences
        //nos campos da dashboard

        //abrir o arquivo cadastro
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)
        //Pegar os dados do arquivo e jogar nos TextViews

        textNome.text  = arquivo.getString("nome","")
         textProfissao.text = arquivo.getString("profissao","")
         textAltura.text = arquivo.getFloat("altura", 0.0f).toString()

    }
}