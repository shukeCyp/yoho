package com.example.protocol

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
data class BaseRespEntity<T>(
    val code: Int,
    val data: T,
    val msg: String
)
