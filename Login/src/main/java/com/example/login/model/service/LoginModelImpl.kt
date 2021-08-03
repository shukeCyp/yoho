package com.example.login.model.service

import com.example.login.contract.LoginContract
import com.example.login.model.api.LoginApi
import com.example.login.model.entity.LoginReqEntity
import com.example.login.model.entity.LoginRespEntity
import com.example.net.RetrofitFactory
import com.example.protocol.BaseRespEntity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
class LoginModelImpl : LoginContract.LoginModel {
    override fun getCode(observer: Observer<String>) {
            RetrofitFactory.retrofitInstance.retrofit.create(LoginApi::class.java)
           .GetPhoneCode()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe(observer)
    }

    override fun login(
        phoneNumber: String,
        password: String,
        observer: Observer<BaseRespEntity<LoginRespEntity>>
    ){
        RetrofitFactory.retrofitInstance.retrofit.create(LoginApi::class.java)
            .login(LoginReqEntity("2077-12-05",0,password,"1",phoneNumber))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

}

