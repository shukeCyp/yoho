package com.example.common.sp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *   @Author:YaPeng
 *   @Date:2021/7/23
 *   @Email:3536815334@qq.com
 */
class SpPropDelegate<T>(
    private val key:String,
    private val defaultvalue:T,
    private val IsCommit:Boolean
) : ReadWriteProperty<Any?,T> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return SPUtils.getValue(key,defaultvalue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        SPUtils.putValue(key,value,IsCommit)
    }
}