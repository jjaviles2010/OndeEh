package com.JLApps.ondeeh.base

import com.JLApps.ondeeh.inject.components.DaggerPresenterInjector
import com.JLApps.ondeeh.inject.components.PresenterInjector
import com.JLApps.ondeeh.inject.module.ContextModule
import com.JLApps.ondeeh.inject.module.NetworkModule
import com.JLApps.ondeeh.ui.main.MainPresenter

abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    val presenterInjector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is MainPresenter -> presenterInjector.inject(this)
        }
    }

    open fun onViewCreated() {

    }

    open fun onViewDestroyed() {

    }
}