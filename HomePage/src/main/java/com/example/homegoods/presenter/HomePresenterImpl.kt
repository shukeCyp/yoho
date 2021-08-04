package com.example.homegoods.presenter

import com.example.homegoods.contract.HomeContract
import com.example.homegoods.model.entity.BaseGoodsEntity
import com.example.homegoods.model.entity.GoodsEntity
import com.example.homegoods.repository.HomeRepositoryImpl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
class HomePresenterImpl(v : HomeContract.HomeView) : HomeContract.HomePresenter(v){

    override fun getGoodsList() {
        mRepository.getGoodsList(object : Observer<BaseGoodsEntity<GoodsEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseGoodsEntity<GoodsEntity>) {
                mView.get()!!.success(t.data)
            }

            override fun onError(e: Throwable) {
                mView.get()!!.faild(e)
            }

            override fun onComplete() {

            }

        })
    }

    override fun createRepostory(): HomeContract.HomeRepository {
        return HomeRepositoryImpl()
    }
}