package com.tandong.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.tandong.kotlin.R
import com.tandong.kotlin.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_second.*


class SencondActivity : AppCompatActivity() {
    private var name: String? = null
    private var id: Int? = null
    private var adapter: ListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    private var list: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    private fun initView() {
        name = intent.getStringExtra("name")
        id = intent.getIntExtra("id", 1)
        tv_intent.setText(name + " " + id)
        layoutManager = LinearLayoutManager(this)
        rv.setLayoutManager(layoutManager)
        layoutManager!!.orientation = OrientationHelper.VERTICAL
        list = ArrayList<String>()
        for (i in 0..9) {
            list!!.add("" + i)
        }
        adapter = ListAdapter(this@SencondActivity, list!!);
        rv.setAdapter(adapter)
    }
}
