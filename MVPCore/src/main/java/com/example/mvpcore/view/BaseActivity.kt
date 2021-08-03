package com.example.mvpcore.view

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.common.ConstValue

/**
 *   @Author:YaPeng
 *   @Date:2021/7/22
 *   @Email:3536815334@qq.com
 */
abstract class BaseActivity : AppCompatActivity()  {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initEvent()

        if (IsClearStarBar()){
            ClearStarBar()
        }
    }

    /**
     * 吐司数据
     */
    fun showMsg(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 跳转到另一个Activity
     */
    fun jumpActivity(otherActivity:Class<*>){
        startActivity(Intent(this@BaseActivity,otherActivity))
    }

    /**
     * 携带参数跳转到另一个Activity
     */
    fun jumpActivity(otherActivity: Class<*>,params:Bundle?){
        val intent:Intent = Intent(this@BaseActivity,otherActivity)
        intent.putExtra(ConstValue.JUMP_ACTIVITY_PARAMS_KEY,params)
        startActivity(intent)
    }

    /**
     * 除去状态栏，实现沉浸式布局
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun ClearStarBar(){

        //沉浸式布局
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 是否实现沉浸式布局
     */
    abstract fun IsClearStarBar(): Boolean

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()




}