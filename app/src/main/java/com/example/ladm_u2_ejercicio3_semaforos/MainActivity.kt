package com.example.ladm_u2_ejercicio3_semaforos

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.ladm_u2_ejercicio3_semaforos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //var platon = Filosofo("Platon: la libertad esta en ser dueños de nuestra propia vida\n",binding.mensaje)
    lateinit var socrates : Filosofo
    var semaforo =false

    /*
    SEMAFORO estara en FALSE cuando el recurso compartido este desocupado
    cuando un hilo pidio el recurso debe poner SEMAFORO en TRUE, para indicar qu ¿e esta usandolo
    cuando el hilo termina, cambia a SEMAFORO a FALSE
    EL OTRO HILO revisa anres de intertar tomar el recurso si esta desocupado, si no se cicla hasta que se desocupe
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var platon = Filosofo("Platon: la libertad esta en ser dueños de nuestra propia vida\n",this)
        var platin = Filosofo("Platin: Si ves la calabera significa peligro\n",this)
        var pluton = Filosofo("Pluton: fui un planeta\n",this)
        socrates = Filosofo("Socrates el amigo ha de ser como el dinero, que antes de necesitarlo se sabe elvalor que tiene\n",this)


        binding.hilo1.setOnClickListener{
            platon.start()
            socrates.start()
            platin.start()
            pluton.start()
        }
        binding.hilo2.setOnClickListener{
           if (platon.estaPausado()){
               platin.despausarHilo()
               pluton.despausarHilo()
               socrates.despausarHilo()
               platon.despausarHilo()
               return@setOnClickListener
           }
            platin.pausarHilo()
            pluton.pausarHilo()
            socrates.pausarHilo()
            platon.pausarHilo()

        }

    }
}

//vysor programa para ver emular