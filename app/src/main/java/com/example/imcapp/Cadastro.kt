package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

class Cadastro : AppCompatActivity() {

    //criando objeto, declarando ele
    lateinit var editEmail:EditText
    lateinit var editSenha:EditText
    lateinit var editNome:EditText
    lateinit var editAltura:EditText
    lateinit var editProfissao:EditText
    lateinit var editDataNascimento:EditText
    lateinit var radioMasculino:RadioButton
    lateinit var radioFeminino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro)

        editEmail = findViewById(R.id.edit_novo_email)
        editSenha = findViewById(R.id.edit_novo_senha)
        editNome = findViewById(R.id.edit_novo_nome)
        editAltura = findViewById(R.id.edit_novo_Altura)
        editProfissao = findViewById(R.id.edit_novo_profissao)
        editDataNascimento = findViewById(R.id.edit_novo_data_nascimento)
        radioFeminino = findViewById(R.id.radio_feminino)
        radioMasculino = findViewById(R.id.radio_masculino)
//        supportActionBar!!.hide()


        //Abrir um calendário ao clicar no campo data de nascimento
        editDataNascimento.setOnClickListener{
            abrirCalendario()
        }
    }

    private fun abrirCalendario() {

        //intancia de um calendario
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes= calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        //DatePickerDialog, quando clicar no ok ele  vai mostar os 4 argumentos
        //view, proprio calendario, ano, mes, dia, a -> faz
        //${] - para fazer o esquema do 01, 02
        val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    var mesFinal = ""

                    if(month < 9){
                        mesFinal = "0${month + 1}"
                    }else{
                        mesFinal = "${month+1}"
                    }
                    var diaFinal = ""
                    
                    if(dayOfMonth < 10){
                        diaFinal = "0$dayOfMonth"
                    }else{
                        diaFinal = "$dayOfMonth"
                    }
                    editDataNascimento.setText("$diaFinal/$mesFinal/$year")

                },ano,mes,dia)
        // quando clicar no edit text vai abrir o calendario, vai mostrar con o show
        dpd.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro,menu)
        return true
    }

            // quando o menu é clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Salvar os dados do usuário em um sharedPreferences
        //Criar um arquivo sharedPreferences
        // Se o arquivo já existir o arquivo será aberto, se não existir ele cria
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        //Criar um editor para o arquivo
        //vou comecar a editar o arquivo dados, colocar dados dentro dele
                //text ele é editavel, toString para toFloat
        val editor = dados.edit()
        //put - colocar
        editor.putString("email", editEmail.text.toString())
                editor.putString("senha", editSenha.text.toString())
                editor.putString("nome", editNome.text.toString())
                editor.putFloat("altura", editAltura.text.toString().toFloat())
                editor.putString("nascimento", editDataNascimento.text.toString())
                editor.putString("profissao", editProfissao.text.toString())
                editor.putString("sexo", if(radioFeminino.isChecked) "F" else "M")

        editor.apply()
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
        return true
    }

}