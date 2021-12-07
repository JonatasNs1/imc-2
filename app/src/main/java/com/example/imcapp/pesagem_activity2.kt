package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imcapp.utils.dataAtualBrasil
import java.time.LocalDate

class pesagem_activity2 : AppCompatActivity() {

    lateinit var textViewDataPesagem: TextView
    lateinit var spinnerNivelAtividade: Spinner
    lateinit var editTextNovoPeso: EditText
    lateinit var buttonRegistrarPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem_activity2)

        textViewDataPesagem = findViewById(R.id.text_view_data_pesagem)
        spinnerNivelAtividade = findViewById(R.id.spinner_niveis_atividade)
        editTextNovoPeso = findViewById(R.id.edit_text_novo_peso)
        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)
        supportActionBar!!.hide()

        //para saber que dia é hoje, data de hoje, e chamando a função data atual
        textViewDataPesagem.text = dataAtualBrasil()

        buttonRegistrarPeso.setOnClickListener {
            registrarPeso()
        }
    }
   private fun registrarPeso(){
       //abrir o arquivo
       val cadastro = getSharedPreferences("cadastro", MODE_PRIVATE)
       //em modo edição
       val editor = cadastro.edit()

       editor.putString("data_pesagem", dataAtualBrasil())
       editor.putString("peso", editTextNovoPeso.text.toString())
       editor.putInt("nivel", spinnerNivelAtividade.selectedItemPosition)

       //grava
       editor.commit()

       Toast.makeText(this, "Peso gravado com sucesso!", Toast.LENGTH_SHORT).show()
       finish()
   }
}