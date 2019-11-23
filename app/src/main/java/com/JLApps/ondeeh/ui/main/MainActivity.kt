package com.JLApps.ondeeh.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.JLApps.ondeeh.R
import com.JLApps.ondeeh.base.BaseActivity
import com.JLApps.ondeeh.databinding.ActivityMainBinding
import com.JLApps.ondeeh.model.Endereco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private val loading = ObservableBoolean()

    private fun exibeAlerta(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
    }

    override fun atualizaEndereco(endereco: Endereco) {
        tvLogradouro.text = endereco.logradouro
        tvBairro.text = endereco.bairro
        tvUF.text = endereco.uf
    }

    override fun showLoading() {
        loading.set(true)
    }

    override fun hideLoading() {
        loading.set(false)
    }

    override fun exibeErro(mensagem: String) {
        exibeAlerta(mensagem)
    }

    override fun instantPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        binding.presenter = presenter
        binding.loading = loading
    }
}
