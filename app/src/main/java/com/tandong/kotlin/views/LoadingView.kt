package com.tandong.kotlin.views

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.WindowManager
import com.tandong.kotlin.R

/**
 * Created by office on 2017/7/19.
 */
class LoadingView : Dialog {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, themeResId: Int) : super(context, R.style.Loading) {
        init(context)
    }

    protected constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener) : super(context, cancelable, cancelListener) {
        init(context)
    }

    private fun init(context: Context) {
        setContentView(R.layout.layout_loading)
        setCanceledOnTouchOutside(false)
        val lp = window!!.attributes
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        lp.dimAmount = 0f
        window!!.attributes = lp
    }
}
