package com.tandong.kotlin.net

/**
 * Created by office on 2017/7/19.
 */
interface ResultListener<T> {
    fun complete(t: T)

    fun onError(e: Throwable)
}
