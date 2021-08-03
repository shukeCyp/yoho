package com.example.mvpcore

import java.lang.ref.SoftReference

/**
 *   @Author:YaPeng
 *   @Date:2021/7/22
 *   @Email:3536815334@qq.com
 */
abstract class BasePresenter<Repo:BaseRepository<*>,V : IView>(_view:V) {
    protected lateinit var mRepository: Repo
    protected lateinit var mView:SoftReference<V>
    init {
        mRepository = createRepostory()
        mView = SoftReference<V>(_view)
    }

    abstract fun createRepostory(): Repo
}