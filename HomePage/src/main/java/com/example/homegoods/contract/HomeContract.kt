package com.example.homegoods.contract

import com.example.homegoods.model.entity.BaseGoodsEntity
import com.example.homegoods.model.entity.GoodsEntity
import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import com.example.protocol.BaseRespEntity
import io.reactivex.Observer

/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
interface HomeContract {
    interface HomeModel : IModel{
        fun getGoodsList(observer: Observer<BaseGoodsEntity<GoodsEntity>>)
    }

    abstract class HomeRepository : BaseRepository<HomeModel>(){
        abstract fun getGoodsList(observer: Observer<BaseGoodsEntity<GoodsEntity>>)
    }

    interface HomeView : IView{
        fun success(data:List<GoodsEntity>)
        fun faild(e : Throwable)
    }

    abstract class HomePresenter(_view : HomeView) : BasePresenter<HomeRepository,HomeView>(_view){
        abstract fun getGoodsList(observer: Observer<BaseGoodsEntity<GoodsEntity>>)
    }
}