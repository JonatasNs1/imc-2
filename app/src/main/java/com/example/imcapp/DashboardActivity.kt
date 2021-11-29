package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
        lateinit var textNome: TextView
        lateinit var textProfissao: TextView
        lateinit var textAltura : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        textNome = findViewById(R.id.text_nome_dash)
        textProfissao = findViewById(R.id.text_profissao_dash)
        textAltura = findViewById(R.id.text_altura_dash)

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