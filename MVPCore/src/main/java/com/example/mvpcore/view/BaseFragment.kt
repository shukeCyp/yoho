package com.example.mvpcore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 *   @Author:YaPeng
 *   @Date:2021/7/29
 *   @Email:3536815334@qq.com
 */
abstract class BaseFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(getLayoutId(),null)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initEvent()
    }


    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 吐司消息
     */
    fun ShowMsg(msg : String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


}