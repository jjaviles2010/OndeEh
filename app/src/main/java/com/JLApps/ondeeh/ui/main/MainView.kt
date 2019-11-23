package com.JLApps.ondeeh.ui.main

import androidx.annotation.StringRes
import com.JLApps.ondeeh.base.BaseView
import com.JLApps.ondeeh.model.Endereco

interface MainView: BaseView {

    fun atualizaEndereco(endereco: Endereco)

    fun showLoading()

    fun hideLoading()

    fun exibeErro(mensagem: String)

    fun exibeErro(@StringRes resId: Int) {
        this.exibeErro(getContext().getString(resId))
    }

}