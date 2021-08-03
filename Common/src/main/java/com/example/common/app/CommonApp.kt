package com.example.common.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.BuildConfig
import com.alibaba.android.arouter.launcher.ARouter


/**
 *   @Author:YaPeng
 *   @Date:2021/7/23
 *   @Email:3536815334@qq.com
 */
class CommonApp : Application(){

    override fun onCreate() {
        super.onCreate()

        mContext = this

        //初始化ARouter
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(mContext)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object{
        var mContext:Application?=null
        fun getContext(): Context {
            return mContext!!
        }
    }

}