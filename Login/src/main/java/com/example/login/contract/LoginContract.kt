package com.example.login.contract

import com.example.login.model.entity.LoginRespEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import com.example.protocol.BaseRespEntity
import io.reactivex.Observable
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
interface LoginContract {

    /**
     * M层业务：
     * 1.获取验证码
     * 2.登录
     */
    interface LoginModel : IModel{
        fun getCode(observer: Observer<String>)
        fun login(phoneNumber:String,password:String,observer: Observer<BaseRespEntity<LoginRespEntity>>)
    }


    abstract class LoginRepository : BaseRepository<LoginModel>(){
        abstract fun getCode(observer: Observer<String>)
        abstract fun login(phoneNumber:String,password:String,observer: Observer<BaseRespEntity<LoginRespEntity>>)
    }

    interface LoginView : IView{
        //获取到验证码
        fun getTheCode(data : String)
        //登陆成功
        fun loginSuccess(data:BaseRespEntity<LoginRespEntity>)
        //登录失败返回一个错误信息
        fun faild(throwable: Throwable)
    }

    abstract class LoginPresenter(view:LoginView) : BasePresenter<LoginRepository, LoginView>(view){
        abstract fun getCode()
        abstract fun login(phoneNumber:String,password:String)
    }
}