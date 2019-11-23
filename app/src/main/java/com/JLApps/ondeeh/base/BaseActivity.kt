package com.JLApps.ondeeh.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P: BasePresenter<BaseView>>: BaseView, AppCompatActivity() {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantPresenter()
    }

    protected abstract fun instantPresenter(): P

    override fun getContext(): Context {
        return this
    }
}