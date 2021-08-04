package com.example.homegoods.model.service

import com.example.homegoods.contract.HomeContract
import com.example.homegoods.model.api.HomeApi
import com.example.homegoods.model.entity.BaseGoodsEntity
import com.example.homegoods.model.entity.GoodsEntity
import com.example.net.RetrofitFactory
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
class HomeModeImpl : HomeContract.HomeModel{


    override fun getGoodsList(observer: Observer<BaseGoodsEntity<GoodsEntity>>) {
        RetrofitFactory.retrofitInstance.retrofit.create(HomeApi::class.java)
            .getGoodslist()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}