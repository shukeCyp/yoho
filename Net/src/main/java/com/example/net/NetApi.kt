package com.example.net

import com.example.resp.TokenRespEntity
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

/**
 *   @Author:YaPeng
 *   @Date:2021/7/24
 *   @Email:3536815334@qq.com
 */
interface NetApi {

    /**
     * 获取Token
     */
    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("grant_type") grant_type:String,
        @Field("username") username:String,
        @Field("password") password:String
    ):Call<TokenRespEntity>

}