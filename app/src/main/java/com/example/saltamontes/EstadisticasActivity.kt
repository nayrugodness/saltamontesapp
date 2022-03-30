package com.example.saltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.saltamontes.clases.Operaciones



class EstadisticasActivity : AppCompatActivity() {

    var campCantProcesados: TextView?=null
    var campCantGanan: TextView?=null
    var campCantPierden: TextView?=null
    var campCantRecuperan: TextView?=null

    var operaciones: Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        iniciarComponentes()

        var botonSalir: Button =findViewById(R.id.btn_salirEst)
        botonSalir.setOnClickListener{salir()}

    }

    private fun iniciarComponentes(){
        var miBundle: Bundle? = this.intent.extras
        operaciones=miBundle?.getSerializable("operaciones") as Operaciones

        campCantProcesados=findViewById(R.id.textCantProcesados)
        campCantGanan=findViewById(R.id.textCantGanan)
        campCantPierden=findViewById(R.id.textCantPierden)
        campCantRecuperan=findViewById(R.id.textCantRecuperan)

        val lista=operaciones?.listaEstudiantes
        println("${lista!!.isEmpty()}")
        Toast.makeText(this, "${lista!!.size}", Toast.LENGTH_LONG).show()
        for (est in lista!!){
            campCantProcesados!!.text="$est"


        }

    }

    private fun salir(){
        finish()
    }
}