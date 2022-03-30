package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.saltamontes.clases.Operaciones

class MainActivity : AppCompatActivity() {
    var operaciones: Operaciones?=null
    var miBundle:Bundle?=null
    override fun onCreate(savedInstanceState: Bundle?) {


        Thread.sleep(3000)
        setTheme(R.style.Theme_Saltamontes)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botonRegistro: Button =findViewById(R.id.btn_registro)
        botonRegistro.setOnClickListener{onClick(1)}

        var botonEstadisticas: Button=findViewById(R.id.btn_estadistica)
        botonEstadisticas.setOnClickListener{onClick(2)}

        var botonAyuda:Button=findViewById(R.id.btn_ayuda)
        botonAyuda.setOnClickListener{onClick(3)}
        operaciones= Operaciones()

        miBundle=Bundle()
    }

    private fun onClick(botones : Int){
        when(botones){
            1 ->{
                val intent= Intent(this, RegistroActivity::class.java)
                miBundle?.putSerializable("operaciones", operaciones)
                intent.putExtras(miBundle!!)
                startActivity(intent)
            }
            2 ->{
                val intent= Intent(this, EstadisticasActivity::class.java)
                miBundle?.putSerializable("operaciones", operaciones)
                intent.putExtras(miBundle!!)
                startActivity(intent)
            }
            3 ->{
                val intent= Intent(this, AyudaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}