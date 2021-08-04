package com.example.homegoods.model.api

import com.example.homegoods.model.entity.BaseGoodsEntity
import com.example.homegoods.model.entity.GoodsEntity
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
interface HomeApi {

    @GET("api/Goods/getRecommendGoods?page=1&pagesize=50")
    fun getGoodslist():Observable<BaseGoodsEntity<GoodsEntity>>
}