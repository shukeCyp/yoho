package com.example.search.repository

import android.util.Log
import com.example.mvpcore.annotation.MvpModel
import com.example.protocol.BaseRespEntity
import com.example.search.contract.SearchContract
import com.example.search.model.entity.BaseGoodsEntity
import com.example.search.model.entity.GoodsEntity
import com.example.search.model.service.SearchModelImpl
import io.reactivex.Observable
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
class SearchRepositoryImpl : SearchContract.SearchRepository() {

    @MvpModel
    private var mModel : SearchModelImpl ?= null

    override fun getSearchGoods(
        keyword: String,
        type: String,
        observer: Observer<BaseGoodsEntity<GoodsEntity>>
    ) {
        mModel!!.getSearchGoods(keyword, type, observer)
    }

}