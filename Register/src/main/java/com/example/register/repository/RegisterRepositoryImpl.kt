package com.example.register.repository

import com.example.mvpcore.annotation.MvpModel
import com.example.protocol.BaseRespEntity
import com.example.register.contract.RegisterContract
import com.example.register.model.entity.RegisterRespEntity
import com.example.register.model.service.RegisterModelImpl
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
class RegisterRepositoryImpl : RegisterContract.RegisterRepository() {

    @MvpModel
    private lateinit var mModel : RegisterModelImpl

    override fun register(
        username: String,
        pwd: String,
        sex: String,
        birthday: String,
        observer: Observer<BaseRespEntity<RegisterRespEntity>>,
    ) {
        mModel.register(username, pwd, sex, birthday, observer)
    }

}