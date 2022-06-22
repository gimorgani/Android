package com.exercicio.sql.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
// estou falando que aqui é o meu banco de dados, e coloco as entidades
// falando que minha classe é uma tabela, que essa é a primeira verssão e que não quero que traga todos s escripts
// do meu banco de dados por fora.
// minha classe tem que ser abstrata e do tipo roomdatabase.
// pela minha função abstrata chamo minha interface
@Database(entities = [Usuario::class],version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userdao (): UserDao

    companion object{

        // CLASSE ABSTRATA NÃO GERA OUTRA INSTANCI POR ISSO COLOCOU
        // NO COMPANION OBJECT

        // quero que essa variavel fique visivel para  meu app
        // s partir do momento que ela for instanciada.
        // vai armazenar nosso banco de dados
        // VE COMO A VARIAVEL ESTÁ E AI SIM PRA NÃO HAVER DUPLICIDADE
        @Volatile
        private var INSTANCE : UserDataBase? = null


        // quero ver se essa instancia já existe, se a minha variavel
        // que retorna a instancia for diferente de nula
        // então ela vai retornar a minha INSTANCE que tem o valor de nulo, ou seja,
        // se for diferente de nulo, ela não aceita e retorna o valor de nulo.

        fun getdatabase (context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }


            synchronized(this){
                val instance = Room.databaseBuilder(

                    context.applicationContext,

                    UserDataBase::class.java,

                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }


        }

    }
}