package com.example.search.presenter

import android.util.Log
import com.example.protocol.BaseRespEntity
import com.example.search.contract.SearchContract
import com.example.search.model.entity.BaseGoodsEntity
import com.example.search.model.entity.GoodsEntity
import com.example.search.repository.SearchRepositoryImpl
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
class SearchPresenterImpl(view : SearchContract.SearchView) : SearchContract.SearchPresenter(view) {
    override fun getSearchGoods(keyword: String, type: String) {
        mRepository.getSearchGoods(keyword,type,object : Observer<BaseGoodsEntity<GoodsEntity>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: BaseGoodsEntity<GoodsEntity>) {
                mView.get()!!.getGoodsSuccess(t.data)
            }

            override fun onError(e: Throwable) {
                Log.i("TAG", "onError: ${e}")
            }

            override fun onComplete() {

            }
        })
    }

    override fun createRepostory(): SearchContract.SearchRepository {
        return SearchRepositoryImpl()
    }
}