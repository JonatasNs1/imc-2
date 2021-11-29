package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // remover a toolbar
      supportActionBar!!.hide()

        //instanciar o botao entrar, findViewById<>() - encontrar uma view pelo o id
        val botaoCriarConta = findViewById<Button>(R.id.btn_Criar)

        editEmail = findViewById(R.id.edit_login)
        editSenha = findViewById(R.id.edit_senha_login)
        btnEntrar = findViewById(R.id. buton_entrar)

            //quando clicar no botao entrar ele
        btnEntrar.setOnClickListener {
            login()
        }
        //criar um listener - ouvinte, android fica de olho nesse botao (click)
        botaoCriarConta.setOnClickListener {
            //criar uma intent(), intent precisa de dois parametros, a intent v activiny que está tendo a intent
            val abrirCadastro = Intent(this, Cadastro::class.java)
            startActivity(abrirCadastro)
        }
    }

    //get valor padrao, coloca "" caso não existir
    private fun login() {

        var arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val email = arquivo.getString("email","")
        val senha = arquivo.getString("senha","")



        if( editEmail.text.toString() == email && editSenha.text.toString() == senha){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
        }
    }


}