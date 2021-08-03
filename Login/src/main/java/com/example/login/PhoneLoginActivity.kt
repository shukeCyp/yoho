package com.example.login

import android.os.Handler
import android.os.Message
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.login.contract.LoginContract
import com.example.login.model.entity.LoginRespEntity
import com.example.login.presenter.LoginPresenterImpl
import com.example.mvpcore.annotation.MvpPresenter
import com.example.mvpcore.view.BaseMvpActivity
import com.example.protocol.BaseRespEntity
import kotlinx.android.synthetic.main.activity_phone_login.*
import java.util.*
import java.util.regex.Pattern

@Route(path = "/Login/PhoneLoginActivity")
class PhoneLoginActivity : BaseMvpActivity<LoginPresenterImpl>(),LoginContract.LoginView {

    @MvpPresenter
    private lateinit var mPresenter : LoginPresenterImpl

    private var PhoneCode = 0
    lateinit var timer : Timer
    var index: Int = 60

    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 1){
                login_phone_btn_getCode.text =  (--index).toString()
                if (index <= 0){
                    timer.cancel()
                    login_phone_btn_getCode.isEnabled = true
                    login_phone_btn_getCode.text = "获取验证码"
                    index = 60
                }
            }
        }
    }

    override fun IsClearStarBar(): Boolean {
        return false
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_phone_login
    }

    override fun initEvent() {

        /**
         * 跳转到密码登录
         */
        login_phone_text_tounamelogin.setOnClickListener { toUsernameLogin() }
        /**
         * 验证手机号，获取验证码
         */
        login_phone_btn_getCode.setOnClickListener {
            val pattern = Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$")
            var matcher = pattern.matcher(login_phone_edit_phone.text.trim().toString())
            if (matcher.matches()){
                CodeEvent()
            }else{
                Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show()
            }
        }
        /**
         * 验证验证码
         */
        login_phone_btn_login.setOnClickListener {
            if (login_phone_edit_code.text.trim().isNotBlank()){
                if (login_phone_edit_code.text.trim().toString().toInt() == PhoneCode){
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "登录失败，验证码错误", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show()
            }

        }
        /**
         * 跳转注册
         */
        login_phone_text_toRegister.setOnClickListener {
            ARouter.getInstance().build("/Register/RegisterActivity").navigation()
            this@PhoneLoginActivity.finish()
        }
    }

    private fun CodeEvent() {

        login_phone_btn_getCode.isEnabled = false

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.sendEmptyMessage(1)
            }
        },0,1000)
        mPresenter.getCode()

    }

    override fun initData() {

    }
    /**
     * 点击跳转用户名密码登录页面
     */
    fun toUsernameLogin(){
        jumpActivity(UsernameLoginActivity::class.java)
        this@PhoneLoginActivity.finish()
    }

    override fun getTheCode(data: String) {
        PhoneCode = data.toInt()
        Toast.makeText(this@PhoneLoginActivity, data, Toast.LENGTH_SHORT).show()
    }

    override fun loginSuccess(data: BaseRespEntity<LoginRespEntity>) {

    }

    override fun faild(throwable: Throwable) {

    }



}