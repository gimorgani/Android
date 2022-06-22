package com.exercicio.sql.data


// se conecta com o banco de dados e faz as requisições necessarias
class UserRepository(private val userdao : UserDao) {
    val selectuser = userdao.selectuser()

   fun adduser (usuario: Usuario){
        userdao.adduser(usuario)
    }
}