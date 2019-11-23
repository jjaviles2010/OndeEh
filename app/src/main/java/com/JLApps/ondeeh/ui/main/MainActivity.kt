package com.JLApps.ondeeh.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.JLApps.ondeeh.R
import com.JLApps.ondeeh.base.BaseActivity
import com.JLApps.ondeeh.model.Endereco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private fun exibeAlerta(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    override fun atualizaEndereco(endereco: Endereco) {
        tvLogradouro.text = endereco.logradouro
        tvBairro.text = endereco.bairro
        tvUF.text = endereco.uf
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun exibeErro(mensagem: String) {
        exibeAlerta(mensagem)
    }

    override fun instantPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btPesquisar.setOnClickListener {
            presenter.buscarEndereco(inputCep.text.toString())
        }
    }
}
