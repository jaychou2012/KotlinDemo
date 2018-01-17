package com.tandong.kotlin.net

import android.content.Context
import android.content.DialogInterface

import com.tandong.kotlin.views.LoadingView

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by office on 2017/7/18.
 */
class ResultObserver<T> : Observer<T>, DialogInterface.OnCancelListener {
    private var progress = false
    private var resultListener: ResultListener<T>? = null
    private var loadingView: LoadingView? = null
    private var disposable: Disposable? = null

    constructor(resultListener: ResultListener<T>) {
        this.resultListener = resultListener
    }

    constructor(context: Context, progress: Boolean, resultListener: ResultListener<T>) {
        this.progress = progress
        this.resultListener = resultListener
        if (progress) {
            loadingView = LoadingView(context)
            loadingView!!.setOnCancelListener(this)
        }
    }

    override fun onSubscribe(d: Disposable) {
        this.disposable = d
        if (progress) {
            showProgress()
        }
    }

    override fun onNext(value: T) {
        resultListener!!.complete(value)
    }

    override fun onError(e: Throwable) {
        resultListener!!.onError(e)
        if (progress) {
            hideProgress()
        }
    }

    override fun onComplete() {
        if (progress) {
            hideProgress()
        }
    }

    private fun showProgress() {
        if (loadingView != null) {
            loadingView!!.show()
        }
    }

    private fun hideProgress() {
        if (loadingView != null) {
            if (loadingView!!.isShowing) {
                loadingView!!.dismiss()
            }
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        if (!disposable!!.isDisposed) {
            disposable!!.dispose()
        }
    }
}
