package com.tandong.kotlin.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Created by office on 2018/1/16.
 */
class Utils {

    fun foo(context: Context) {
        Toast.makeText(context, "文本", Toast.LENGTH_LONG).show();
        print("成员函数Foo")
    } // 成员函数

    fun demo(x: Any) {
        if (x is String) {
            print(x.length) // x 自动转换为字符串
        }
    }

    /*
* kotlin对字符串的加强，三个引号"""中可以包含换行、反斜杠等等特殊字符
* */
    fun testString() {
        val str1 = "abc"
        val str2 = """line1\n
        line2
        line3
        """
        val js = """
        function myFunction()
        {
            document.getElementById("demo").innerHTML="My First JavaScript Function";
        }
        """.trimIndent()
        println(str1)
        println(str2)
        println(js)
    }


    /*
    * kotlin字符串模版，可以用$符号拼接变量和表达式
    * */
    fun testString2() {
        val strings = arrayListOf("abc", "efd", "gfg")
        println("First content is $strings")
        println("First content is ${strings[0]}")
        println("First content is ${if (strings.size > 0) strings[0] else "null"}")
    }

    /*
    *Kotlin中，美元符号$是特殊字符，在字符串中不能直接显示，必须经过转义，方法1是用反斜杠，方法二是${'$'}
    * */
    fun testString3() {
        println("First content is \$strings")
        println("First content is ${'$'}strings")
    }

    /*
* 用apply语句简化类的初始化，在类实例化的时候，就可以通过apply把需要初始化的步骤全部实现，非常的简洁
* */
    fun testApply(context: Context) {
        var imgView = ImageView(context).apply {
            setBackgroundColor(0)
            setImageBitmap(null)
        }

        var textView = TextView(context).apply {
            text = "content"
            textSize = 20.0f
            setPadding(10, 0, 0, 0)
        }
    }

    fun test01() {
        val list = listOf(2, 5, 10)
        /*
        * 传人函数来过滤
        * */
        println(list.filter { it > 4 })
    }

    /*
* kotlin中，when是表达式，可以取代Java 中的switch，when的每个分支的最后一行为当前分支的值
* */
    fun getPoint(grade: Char) = when (grade) {
        'A' -> "GOOD"
        'B', 'C' -> {
            println("test when")
            "OK"
        }
        'D' -> "BAD"
        else -> "UN_KNOW"
    }

    /*
* show toast in activity
* */
    fun Activity.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 获取版本号VersionCode
     */
    fun getVersionCode(context: Context): Int {
        val packageManager = context.packageManager
        val packageInfo: PackageInfo
        var versionCode = ""
        try {
            packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            versionCode = packageInfo.versionCode.toString() + ""
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return Integer.parseInt(versionCode)
    }
}