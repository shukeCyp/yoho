package com.example.login.model.entity

/**
 *   @Author:YaPeng
 *   @Date:2021/7/25
 *   @Email:3536815334@qq.com
 */
data class LoginReqEntity(
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)