package com.example.register.contract

import com.example.mvpcore.BasePresenter
import com.example.mvpcore.BaseRepository
import com.example.mvpcore.IModel
import com.example.mvpcore.IView
import com.example.protocol.BaseRespEntity
import com.example.register.model.entity.RegisterRespEntity
import io.reactivex.Observer
import retrofit2.http.Body

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
interface RegisterContract {
    interface RegisterModel : IModel{
        fun register(username:String,pwd:String,sex:String,birthday:String
                     ,observer: Observer<BaseRespEntity<RegisterRespEntity>>)
    }
    abstract class RegisterRepository : BaseRepository<RegisterModel>() {
        abstract fun register(username:String,pwd:String,sex:String,birthday:String
                              ,observer: Observer<BaseRespEntity<RegisterRespEntity>>)
    }
    interface RegisterView : IView{
        fun RegisterSuccess(data:BaseRespEntity<RegisterRespEntity>)
        fun RegisterFaild(throwable: Throwable)
    }
    abstract class RegisterPresenter(view : RegisterView) : BasePresenter<RegisterRepository, RegisterView>(view){
        abstract fun register(username:String,pwd:String,sex:String,birthday:String)
    }
}