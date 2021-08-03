package com.example.mvpcore.view

import android.os.Build
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import com.example.mvpcore.annotation.MvpPresenter

/**
 *   @Author:YaPeng
 *   @Date:2021/7/22
 *   @Email:3536815334@qq.com
 */
abstract class BaseMvpActivity<P : BasePresenter<*,*>> : BaseActivity() {
//    protected lateinit var mPresenter: P
//    init {
//        mPresenter = createPresenter()
//    }
//
//    abstract fun createPresenter(): P

    init {
        initPresenter()
    }

    private fun initPresenter(){
        val thisType = this@BaseMvpActivity::class.java
        val declaredfields = thisType.declaredFields
        if (declaredfields.size > 0){
            for (field in declaredfields){
                field.isAccessible = true
                val annotation = field.getAnnotation(MvpPresenter::class.java)
                if (annotation != null){
                    var name:String = ""
                    if (Build.VERSION.SDK_INT > 28){
                        name = field.genericType.typeName
                    }
                    else{
                        name = field.type.name
                    }
                    val typeName = Class.forName(name)
                    val constructor = typeName.constructors
                    val newinstance = constructor.get(0).newInstance(this@BaseMvpActivity)
                    field.set(this,newinstance)
                }
            }
        }
        else{
            throw IllegalStateException("no any Presenter")
        }
    }

}