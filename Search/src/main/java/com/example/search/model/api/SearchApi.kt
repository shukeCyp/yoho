package com.example.search.model.api


import com.example.search.model.entity.BaseGoodsEntity
import com.example.search.model.entity.GoodsEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */

interface SearchApi {
    /**
     * 搜索获取商品列表
     */
    @GET("api/Goods/getGoods")
    fun getGoodsList(@Query("keyword") keyword:String,@Query("type") type:String
    ,@Query("pageno") pageno:String,@Query("pagesize") pagesize:String):Observable<BaseGoodsEntity<GoodsEntity>>

}