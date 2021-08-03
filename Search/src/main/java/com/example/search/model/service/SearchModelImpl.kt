package com.example.search.model.service

import com.example.net.RetrofitFactory
import com.example.search.contract.SearchContract
import com.example.search.model.api.SearchApi
import com.example.search.model.entity.BaseGoodsEntity
import com.example.search.model.entity.GoodsEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
class SearchModelImpl : SearchContract.SearchModel {
    override fun getSearchGoods(
        keyword: String,
        type: String,
        observer: Observer<BaseGoodsEntity<GoodsEntity>>
    ) {
        RetrofitFactory.retrofitInstance.create(SearchApi::class.java)
            .getGoodsList(keyword,type,"1","20")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

    }

}