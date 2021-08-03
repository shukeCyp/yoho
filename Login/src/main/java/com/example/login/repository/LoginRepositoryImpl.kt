package com.example.login.repository

import com.example.login.contract.LoginContract
import com.example.login.model.entity.LoginRespEntity
import com.example.login.model.service.LoginModelImpl
import com.example.mvpcore.annotation.MvpModel
import com.example.protocol.BaseRespEntity
import io.reactivex.Observable
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
class LoginRepositoryImpl : LoginContract.LoginRepository() {

    @MvpModel
    private lateinit var mModel : LoginModelImpl

    override fun getCode(observer: Observer<String>){
        mModel.getCode(observer)
    }

    override fun login(phoneNumber: String, password: String, observer: Observer<BaseRespEntity<LoginRespEntity>>) {
        mModel.login(phoneNumber,password,observer)
    }


}