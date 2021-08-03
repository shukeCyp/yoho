package com.example.search.contract

import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import com.example.search.model.entity.BaseGoodsEntity
import com.example.search.model.entity.GoodsEntity
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
interface SearchContract {

    interface SearchModel : IModel{
        fun getSearchGoods(keyword:String,type:String,observer: Observer<BaseGoodsEntity<GoodsEntity>>)
    }

    abstract class SearchRepository : BaseRepository<SearchModel>(){
        abstract fun getSearchGoods(keyword:String,type:String,observer: Observer<BaseGoodsEntity<GoodsEntity>>)
    }

    interface SearchView : IView{
        fun getGoodsSuccess(data:List<GoodsEntity>)
        fun getGoodsFaild(throwable: Throwable)
    }

    abstract class SearchPresenter(view:SearchView) : BasePresenter<SearchRepository,SearchView>(view){
        abstract fun getSearchGoods(keyword:String,type:String)
    }
}