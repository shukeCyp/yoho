package com.example.mvpcore.annotation

/**
 *   @Author:YaPeng
 *   @Date:2021/8/2
 *   @Email:3536815334@qq.com
 *   @Target(AnnotationTarget.FIELD)->属性上使用
 *   @Retention(AnnotationRetention.RUNTIME)->运行时有效
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MvpModel{

}
