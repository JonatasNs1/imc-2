package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class Cadastro : AppCompatActivity() {

    //criando objeto, declarando ele
    lateinit var editEmail:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro)

        editEmail = findViewById(R.id.edit_novo_email)
//        supportActionBar!!.hide()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Salvar os dados do usuário em um sharedPreferences
        //Criar um arquivo sharedPreferences
        // Se o arquivo já existir o arquivo será aberto
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        //Criar um editor para o arquivo
        //vou comecar a editar o arquivo dados
        val editor = dados.edit()
        //put - colocar
        editor.putString("email", editEmail.text.toString())
        editor.apply()

        return true
    }

}