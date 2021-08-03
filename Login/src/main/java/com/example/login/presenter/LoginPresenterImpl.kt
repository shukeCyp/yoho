package com.example.login.presenter

import com.example.login.contract.LoginContract
import com.example.login.model.entity.LoginRespEntity
import com.example.login.repository.LoginRepositoryImpl
import com.example.protocol.BaseRespEntity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
class LoginPresenterImpl(_view: LoginContract.LoginView) : LoginContract.LoginPresenter(_view) {

    override fun getCode() {
        mRepository.getCode(object : Observer<String>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: String) {
                mView.get()!!.getTheCode(t)
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

        })
    }

    override fun login(phoneNumber: String, password: String) {
        mRepository.login(phoneNumber,password,object : Observer<BaseRespEntity<LoginRespEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseRespEntity<LoginRespEntity>) {
               if (t.code == 200){
                   mView.get()!!.loginSuccess(t)
               }
            }

            override fun onError(e: Throwable) {
                mView.get()!!.faild(e)
            }

            override fun onComplete() {

            }

        })
    }

    override fun createRepostory(): LoginContract.LoginRepository {
        return LoginRepositoryImpl()
    }
}