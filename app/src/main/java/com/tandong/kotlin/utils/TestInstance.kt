package com.tandong.kotlin.utils

import android.util.Log

/**
 * Created by Tandong on 2018/1/19.
 */
class TestInstance private constructor() {

    init {
        Log.i("info", "构造方法")
    }

    private object SingletonHolder {
        val instance = TestInstance()
    }

    fun method() {
        Log.i("info", "构造方法SingletonInner")
    }

    companion object {

        val instance: TestInstance
            @Synchronized get() = SingletonHolder.instance
    }
}
