package com.tandong.kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.tandong.kotlin.R
import com.tandong.kotlin.base.BaseActivity
import com.tandong.kotlin.entity.User
import com.tandong.kotlin.net.ApiClient
import com.tandong.kotlin.net.ResultListener
import com.tandong.kotlin.net.ResultObserver
import com.tandong.kotlin.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call

class MainActivity : BaseActivity(), View.OnClickListener {
    private var users: Call<List<User>>? = null
    private var userList: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
    }

    private fun initView() {
        var utils = Utils();
        utils.foo(this);
        tv_tips.setText("测试控件");
        utils.testString3();
        utils.testApply(this);
        utils.getPoint('B');
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png").into(iv_img);
        Log.i("info", "测试输出Log");
        runOnUiThread(Runnable {
            kotlin.run {
                toast("测试弹出提示")
            }
        })
        tv_getdata.setOnClickListener(this);
        tv_intent.setOnClickListener(this)
        Utils().foo(this);
        ApiClient().getListRepo("1", ResultObserver(object : ResultListener<List<User>> {
            override fun complete(t: List<User>) {
                showToast(this@MainActivity, t.size.toString() + "  " + t.get(0).full_name)
            }

            override fun onError(e: Throwable) {

            }

        }));
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_getdata -> {
                getData()
            }
            R.id.tv_intent -> {
                var intent = Intent(this@MainActivity, SencondActivity::class.java);
                intent.putExtra("name", "名字")
                intent.putExtra("id", 12)
                startActivity(intent)
            }
        }
    }

    fun getData() {
        Thread(Runnable {
            users = ApiClient().getListRepo("1");
            userList = users!!.execute().body();
            for (i in userList!!.indices) {
                Log.i("info", "用户：" + userList!!.get(i).full_name);
            }
        }).start();
    }
}
