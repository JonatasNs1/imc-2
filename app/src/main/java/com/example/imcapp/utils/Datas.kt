package com.example.imcapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

//toda vez que chamar essa função ela vai voltar sempre a data atual, no nosso horario
fun dataAtualBrasil():String{

    // Obter a data atual, ou seja, hoje, data no formato universal
    val hoje = LocalDate.now()

    //Determinar o formato da data brasileiro
    // DateTimeFormatter -é um formatador de data e hora
    val formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    // Converter a data para Brasil, format serve para converter a data atual universal para nosso horario
    val hojeBrasil = hoje.format(formatoBrasil)

    //retornando a data atualizada
    return hojeBrasil
}