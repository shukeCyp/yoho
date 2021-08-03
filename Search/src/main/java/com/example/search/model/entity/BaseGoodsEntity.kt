package com.example.search.model.entity

/**
 *   @Author:YaPeng
 *   @Date:2021/7/30
 *   @Email:3536815334@qq.com
 */
data class BaseGoodsEntity<T>(
    val code: Int,
    val data: List<T>,
    val msg: String
)