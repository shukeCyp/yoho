package com.example.register.model.entity

/**
 *   @Author:YaPeng
 *   @Date:2021/7/26
 *   @Email:3536815334@qq.com
 */
data class RegisterReqEntity(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)