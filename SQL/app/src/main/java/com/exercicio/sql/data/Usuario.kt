package com.exercicio.sql.data

import androidx.room.Entity
import androidx.room.PrimaryKey


// Enteity fala que os dados colocados nessa classe vão ser uma tabela
// no nosso banco de dados.
//o primarykey(...) fala que o id de cada usuario cadastrado vai ser
// gerado de forma automatica.
@Entity(tableName = "user_table")
class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    var nome : String,
    var sobrenome : String,
    var idade : Int
) {
}