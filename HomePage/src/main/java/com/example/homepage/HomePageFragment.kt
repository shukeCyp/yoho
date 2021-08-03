package com.example.homepage

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.mvpcore.view.BaseFragment
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.homepage_fragment_layout.*

/**
 *   @Author:YaPeng
 *   @Date:2021/7/29
 *   @Email:3536815334@qq.com
 */
class HomePageFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.homepage_fragment_layout
    }

    override fun initData() {
        /**
         * 设置轮播图
         */
        fragment_homepage_banner_banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                if (imageView != null) {
                    imageView.setImageResource(path as Int)
                }
            }
        })
        fragment_homepage_banner_banner.setImages(
            listOf(R.drawable.banner_a,R.drawable.banner_b,R.drawable.banner_c)
        )
        fragment_homepage_banner_banner.start()
        /**
         * 网格列表
         */
        fragment_homepage_grid_gridview.adapter = HomePageGridAdapter(
            mutableListOf(R.drawable.gridview_a,R.drawable.gridview_b,R.drawable.gridview_c,
                R.drawable.gridview_d,R.drawable.gridview_e,R.drawable.gridview_f,
                R.drawable.gridview_g,R.drawable.gridview_h,R.drawable.gridview_i,R.drawable.gridview_j),
            mutableListOf("有货超市","数码超市","有货服饰","有货生鲜","有货到家",
            "充值缴费","领货豆","领券","借钱","PLUS会员")
        )
    }

    override fun initEvent() {
        /**
         * 点击搜索框跳转搜索模块
         */
        fragment_homepage_search_textview.setOnClickListener {  }
    }


}