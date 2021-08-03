package com.example.register.model.api

import com.example.protocol.BaseRespEntity
import com.example.register.model.entity.RegisterReqEntity
import com.example.register.model.entity.RegisterRespEntity
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
interface RegisterApi {

    @POST("api/User/register")
    fun register(@Body param:RegisterReqEntity):Observable<BaseRespEntity<RegisterRespEntity>>

}