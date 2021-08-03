package com.example.login

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.login.contract.LoginContract
import com.example.login.model.entity.LoginRespEntity
import com.example.login.presenter.LoginPresenterImpl
import com.example.mvpcore.annotation.MvpPresenter
import com.example.mvpcore.view.BaseActivity
import com.example.mvpcore.view.BaseMvpActivity
import com.example.protocol.BaseRespEntity
import kotlinx.android.synthetic.main.activity_username_login.*

/**
 *   @Author:YaPeng
 *   @Date:2021/7/24
 *   @Email:3536815334@qq.com
 */
@Route(path = "/Login/UsernameLoginActivity")
class UsernameLoginActivity : BaseMvpActivity<LoginPresenterImpl>(),LoginContract.LoginView {

    @MvpPresenter
    private lateinit var mPresenter : LoginPresenterImpl

    override fun IsClearStarBar(): Boolean {
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_username_login
    }

    override fun initEvent() {
        /**
         * 跳转验证码登录页面
         */
        login_uanme_text_tophonelogin.setOnClickListener { toPhoneLogin() }
        /**
         * 登录
         */
        login_uname_btn_login.setOnClickListener {
            if (login_uname_edit_username.text.isNotBlank() && login_uname_edit_password.text.isNotBlank()){
                mPresenter.login(login_uname_edit_username.text.trim().toString(),login_uname_edit_password.text.trim().toString())
            }else{
                Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show()
            }
        }
        /**
         * 跳转注册
         */
        login_uanme_text_toregister.setOnClickListener {
            ARouter.getInstance().build("/Register/RegisterActivity").navigation()
            this@UsernameLoginActivity.finish()
        }
    }

    override fun initData() {

    }
    fun toPhoneLogin(){
        jumpActivity(PhoneLoginActivity::class.java)
        this@UsernameLoginActivity.finish()
    }

    override fun getTheCode(data: String) {

    }

    override fun loginSuccess(data: BaseRespEntity<LoginRespEntity>) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
    }

    override fun faild(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
        Log.i("TAG", "faild: "+throwable.message)
    }
}