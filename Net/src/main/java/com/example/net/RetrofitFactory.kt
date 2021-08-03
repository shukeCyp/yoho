package com.example.net

import android.util.Log
import com.example.common.ConstValue
import com.example.common.sp.SpPropDelegate
import com.example.resp.TokenRespEntity
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *   @Author:YaPeng
 *   @Date:2021/7/22
 *   @Email:3536815334@qq.com
 */

class RetrofitFactory private constructor(){

    /**
     * 使用属性委托间接管理Token
     */
    private var MyToken: String by SpPropDelegate<String>("token","",true)

    private var auto_code : String by SpPropDelegate<String>("auto_code","",false)
    companion object{
        val retrofitInstance:RetrofitFactory by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitFactory()
        }
    }

    val retrofit:Retrofit
    init {
        retrofit = Retrofit.Builder()
            .client(createOkHttpClient())
            .baseUrl(BuildConfig.BASEURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * 创建自定义的OKHTTPClient客户端
     */
    private fun createOkHttpClient(): OkHttpClient {
       return OkHttpClient.Builder()
            .addInterceptor(createTokenInterceptor())
            .addInterceptor(createHttpLogInterceptor())
            .readTimeout(ConstValue.NET_TIMEOUT,TimeUnit.SECONDS)
            .connectTimeout(ConstValue.NET_TIMEOUT,TimeUnit.SECONDS)
            .callTimeout(ConstValue.NET_TIMEOUT,TimeUnit.SECONDS)
            .build()
    }

    /**
     * 创建OKHttp的日志拦截器
     */
    private fun createHttpLogInterceptor(): Interceptor {
        var logInterceptor : HttpLoggingInterceptor= HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    /**
     *创建处理token的拦截器
     */
    private fun createTokenInterceptor(): Interceptor {
        /**
         * 逻辑
         * 先从Sp中取token
         * 存在：直接加到请求头中
         * 不存在：获取token加到请求头中，并且存到Sp中
         */
        return Interceptor {
            var request = it.request()
            var response:Response ?= null
            if (MyToken.isNotBlank()){
              response = it.proceed(addTokenHeader(request,it))
            }else{
              response = it.proceed(request)
            }

            if (response!!.code() == 401){
                RequestToken()
                response = it.proceed(addTokenHeader(request, it))
            }
            response
        }
    }

    /**
     * 添加Token的请求头
     */
    fun addTokenHeader(request:Request,chain:Interceptor.Chain):Request{
       return request
               .newBuilder()
               .addHeader("Authorization","bearer ${MyToken}").build()
    }
    /**
     * 获取新的Token
     */
    fun RequestToken(){
        auto_code = "0a1db1f41dd1dc1b71b013c1da1551301651ec1ec1601101"
        var netApi : NetApi= create(NetApi::class.java)
        var tokenService : Call<TokenRespEntity> = netApi.getToken("password", auto_code, "")
        var result = tokenService.execute()
        //取到token
        var ResultToken = result.body()!!.access_token

        MyToken = ResultToken
    }
    /**
     * 通过传入的请求接口返回具体的实体对象
     */
    fun <T> create(server:Class<T>):T{
        return retrofit.create(server)
    }
}