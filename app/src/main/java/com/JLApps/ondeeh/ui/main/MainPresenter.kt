package com.JLApps.ondeeh.ui.main

import com.JLApps.ondeeh.R
import com.JLApps.ondeeh.base.BasePresenter
import com.JLApps.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter(mainView: MainView): BasePresenter<MainView>(mainView) {

    @Inject
    lateinit var enderecoAPI: EnderecoAPI

    lateinit var subscription: Disposable

    override fun onViewCreated() {
        super.onViewCreated()
        view.hideLoading()
    }

    fun buscarEndereco(cep: String) {
        view.showLoading()
        subscription = enderecoAPI
            .pesquisar(cep)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate{ view.hideLoading() }
            .subscribe(
                {endereco -> view.atualizaEndereco(endereco)},
                {erro -> view.exibeErro(erro.message ?: "Erro")}
            )
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription.dispose()
    }
}