package com.example.mine

import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mvpcore.view.BaseFragment
import kotlinx.android.synthetic.main.activity_mine_fragment.*

class MineFragment : BaseFragment() {
    override fun getLayoutId(): Int {
       return R.layout.activity_mine_fragment
    }

    override fun initData() {
        mine_fragment_login.setOnClickListener {
            Log.i("TAG", "Login")
            ARouter.getInstance().build("/Login/UsernameLoginActivity").navigation()
        }
        mine_fragment_register.setOnClickListener {
            ARouter.getInstance().build("/Register/RegisterActivity").navigation()
        }
    }

    override fun initEvent() {

    }

}