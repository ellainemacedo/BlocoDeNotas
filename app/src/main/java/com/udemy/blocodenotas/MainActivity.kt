package com.udemy.blocodenotas

import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.udemy.blocodenotas.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // variavel recebe a classe PreferenciaAnotação e recupera o contexto
        val preferencia = PreferenciaAnotacao(applicationContext)
        val botaoSalvar = binding.fabCheck

        botaoSalvar.setOnClickListener{
            val anotacaoRecuperada = binding.edtContainer.edtAnotacao.text.toString()

            if (anotacaoRecuperada == ""){
                Toast.makeText(this, "Digite sua anotação", Toast.LENGTH_SHORT).show()
            } else {
                preferencia.salvarAnotacao(anotacaoRecuperada)
                Toast.makeText(this, "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        val anotacao = preferencia.recuperarAnotacao()
        if (anotacao != ""){
            binding.edtContainer.edtAnotacao.setText(anotacao)
        }

    }
}