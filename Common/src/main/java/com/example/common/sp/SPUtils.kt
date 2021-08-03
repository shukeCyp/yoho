package com.example.common.sp

import android.content.Context
import android.content.SharedPreferences
import com.example.common.app.CommonApp

/**
 *   @Author:YaPeng
 *   @Date:2021/7/23
 *   @Email:3536815334@qq.com
 */
object SPUtils {

    private val sp:SharedPreferences by lazy {
        createSharepreferences()
    }

    /**
     * 创建Sp
     */
    private fun createSharepreferences() : SharedPreferences{
         return CommonApp.getContext().getSharedPreferences("cyp",Context.MODE_PRIVATE)
    }


    /**
     * 往Sp中存储值
     */
    fun <T> putValue(key:String,value:T,IsCommit:Boolean){
        sp.edit().apply(){
            when(value){
                is String -> putString(key,value)
                is Boolean -> putBoolean(key,value)
                is Float -> putFloat(key,value)
                is Long -> putLong(key,value)
                is Int -> putInt(key,value)
                else -> throw Exception("参数异常")
            }
            if (IsCommit) commit() else apply()
        }
    }
    /**
     * 从Sp中取值
     */
    fun <T> getValue(key:String,value:T) : T{
        return when(value){
                is String -> sp.getString(key,value)
                is Boolean -> sp.getBoolean(key,value)
                is Float -> sp.getFloat(key,value)
                is Long -> sp.getLong(key,value)
                is Int -> sp.getInt(key,value)
                else -> throw Exception("参数异常")
            }as T
    }
}