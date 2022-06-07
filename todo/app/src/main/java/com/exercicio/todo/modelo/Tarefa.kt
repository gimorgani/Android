package com.exercicio.todo.modelo
/*lista base
*/

data class Tarefa(
    var nome:String,
    var descricao:String,
    var responsavel:String,
    var data:String,
    var status:Boolean,
    var categotia:String
) {
}