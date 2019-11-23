package com.JLApps.ondeeh.inject.components

import com.JLApps.ondeeh.base.BaseView
import com.JLApps.ondeeh.inject.module.ContextModule
import com.JLApps.ondeeh.inject.module.NetworkModule
import com.JLApps.ondeeh.ui.main.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}


