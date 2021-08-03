package com.example.register

import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mvpcore.annotation.MvpPresenter
import com.example.mvpcore.view.BaseMvpActivity
import com.example.protocol.BaseRespEntity
import com.example.register.contract.RegisterContract
import com.example.register.model.entity.RegisterRespEntity
import com.example.register.presenter.RegisterPresenterImpl
import kotlinx.android.synthetic.main.register_activity_layout.*

@Route(path = "/Register/RegisterActivity")
class RegisterActivity : BaseMvpActivity<RegisterPresenterImpl>() , RegisterContract.RegisterView {


    @MvpPresenter
    private lateinit var mPresenter : RegisterPresenterImpl

    override fun IsClearStarBar(): Boolean {
        return true
    }

    override fun getLayoutId(): Int {
        return R.layout.register_activity_layout
    }

    override fun initEvent() {
        register_button_register.setOnClickListener { 
            if (register_edit_username.text.trim().toString().isEmpty()){
                Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (register_edit_password.text.trim().toString().isEmpty()){
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (register_edit_againpassword.text.trim().toString().isEmpty()){
                Toast.makeText(this, "二次密码不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!register_checkbox_isagree.isChecked){
                Toast.makeText(this, "请同意志强是沙雕协议", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!register_edit_password.text.trim().toString()
                    .equals(register_edit_againpassword.text.trim().toString())){
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            mPresenter.register(register_edit_username.text.trim().toString()
            ,register_edit_password.text.trim().toString()
            ,"1","2011-11-11")
        }
//        mPresenter.register("shuke","shuke","1","2012-12-12")
    }

    override fun initData() {

    }


    override fun RegisterSuccess(data: BaseRespEntity<RegisterRespEntity>) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show()
    }

    override fun RegisterFaild(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}