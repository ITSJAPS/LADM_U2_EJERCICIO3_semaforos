package com.example.ladm_u2_ejercicio3_semaforos

import android.widget.TextView
import kotlin.random.Random

class Filosofo (mensaje:String,act: MainActivity):Thread(){

    private var pausar =false
    private var ejecutar=true

    var men=mensaje
    var act=act
    var contador=1

    // Platon: la libertad esta en ser dueños de nuestra propia vida\n
    // Socrates el amigo ha de ser como el dinero, que antes de necesitarlo se sabe elvalor que tiene\n

    override  fun run(){
        super.run()

        var dormirAntes= Random.nextInt(8000).toLong()   //domimos al ejecutar el boton del filosofo aleatoriamente
        sleep(dormirAntes)
        while (ejecutar){
            if (!pausar){
                    //sino esta pausado
                while (act.semaforo){
                    println("Esto esperando${men} ")
                }
                act.semaforo=true//Bloqueo del recurso esta ocupado el semaforo

                act.runOnUiThread {
                    act.binding.mensaje.text= "-${contador++}-"+men+act.binding.mensaje.text.toString()
                }

                act.semaforo=false // esta desocupado

            }
            var dormir = Random.nextInt(8000).toLong()
                sleep(dormir)

        }

    }

    fun terminarHilo(){
        ejecutar=false
    }
    fun pausarHilo(){
        pausar=true
    }
    fun despausarHilo(){
        pausar=false
    }

    fun estaPausado():Boolean{
        return  pausar
    }

}