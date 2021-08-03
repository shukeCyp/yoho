package com.example.register.presenter

import com.example.protocol.BaseRespEntity
import com.example.register.contract.RegisterContract
import com.example.register.model.entity.RegisterRespEntity
import com.example.register.repository.RegisterRepositoryImpl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
class RegisterPresenterImpl(view: RegisterContract.RegisterView) : RegisterContract.RegisterPresenter(view) {
    override fun register(username: String, pwd: String, sex: String, birthday: String) {
        mRepository.register(username,pwd,sex,birthday,object : Observer<BaseRespEntity<RegisterRespEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseRespEntity<RegisterRespEntity>) {
                mView.get()!!.RegisterSuccess(t)
            }

            override fun onError(e: Throwable) {
                mView.get()!!.RegisterFaild(e)
            }

            override fun onComplete() {

            }

        })
    }

    override fun createRepostory(): RegisterContract.RegisterRepository {
        return RegisterRepositoryImpl()
    }
}