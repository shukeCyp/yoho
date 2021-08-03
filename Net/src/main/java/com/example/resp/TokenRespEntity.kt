package com.example.resp

/**
 *   @Author:YaPeng
 *   @Date:2021/7/24
 *   @Email:3536815334@qq.com
 */
data class TokenRespEntity(var access_token:String,var token_type:String,var expires_in:Int=0) {
}