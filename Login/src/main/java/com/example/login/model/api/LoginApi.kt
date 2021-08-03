package com.example.login.model.api

import com.example.login.model.entity.LoginReqEntity
import com.example.login.model.entity.LoginRespEntity
import com.example.protocol.BaseRespEntity
import io.reactivex.Observable
import retrofit2.http.*

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
interface LoginApi {

    @GET("api/User/authcode")
    fun GetPhoneCode() : Observable<String>

    @POST("api/User/login")
    fun login(@Body param : LoginReqEntity) : Observable<BaseRespEntity<LoginRespEntity>>
}