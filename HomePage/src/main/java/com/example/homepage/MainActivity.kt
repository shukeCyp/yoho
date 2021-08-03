package com.example.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvpcore.view.BaseActivity

class MainActivity : BaseActivity() {

    override fun IsClearStarBar(): Boolean {
        return true
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initEvent() {

    }

    override fun initData() {

    }
}