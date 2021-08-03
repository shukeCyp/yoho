package com.example.register.model.service

import com.example.net.RetrofitFactory
import com.example.protocol.BaseRespEntity
import com.example.register.contract.RegisterContract
import com.example.register.model.api.RegisterApi
import com.example.register.model.entity.RegisterReqEntity
import com.example.register.model.entity.RegisterRespEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
class RegisterModelImpl : RegisterContract.RegisterModel{
    override fun register(
        username: String,
        pwd: String,
        sex: String,
        birthday: String,
        observer: Observer<BaseRespEntity<RegisterRespEntity>>,
    ) {
        RetrofitFactory.retrofitInstance.retrofit.create(RegisterApi::class.java)
            .register(RegisterReqEntity(birthday,1,pwd,sex,username))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}