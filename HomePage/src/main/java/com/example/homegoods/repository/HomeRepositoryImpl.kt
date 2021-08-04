package com.example.homegoods.repository

import com.example.homegoods.contract.HomeContract
import com.example.homegoods.model.entity.BaseGoodsEntity
import com.example.homegoods.model.entity.GoodsEntity
import com.example.homegoods.model.service.HomeModeImpl
import com.example.mvpcore.annotation.MvpModel
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
class HomeRepositoryImpl : HomeContract.HomeRepository() {

    @MvpModel
    private lateinit var goodslistModel : HomeModeImpl

    override fun getGoodsList(observer: Observer<BaseGoodsEntity<GoodsEntity>>) {
        goodslistModel.getGoodsList(observer)
    }
}