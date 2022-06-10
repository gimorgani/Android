package com.exercicio.todo.modelo

data class Categoria (
    var id:Long,
    var descricao:String?,
    var tarefas:List<Tarefa>?
) {

}