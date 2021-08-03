package com.example.yoho



import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.launcher.ARouter
import com.example.cart.CartFragment
import com.example.discover.DiscoverFragment
import com.example.homepage.HomePageFragment
import com.example.mine.MineFragment
import com.example.mvpcore.view.BaseActivity
import com.example.soft.SoftFragment
import com.example.yoho.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun IsClearStarBar(): Boolean {
        return true
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initEvent() {
//        ARouter.getInstance().build("/Login/UsernameLoginActivity").navigation()
//        jumpActivity(PhoneLoginActivity::class.java)
        app_mainactivity_bottomnavigationview.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.item_tab1 -> app_mainactivity_viewpager.currentItem = 0
                    R.id.item_tab2 -> app_mainactivity_viewpager.currentItem = 1
                    R.id.item_tab3 -> app_mainactivity_viewpager.currentItem = 2
                    R.id.item_tab4 -> app_mainactivity_viewpager.currentItem = 3
                    R.id.item_tab5 -> app_mainactivity_viewpager.currentItem = 4
                }
                return true
            }
        })

        app_mainactivity_viewpager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> app_mainactivity_bottomnavigationview.selectedItemId = R.id.item_tab1
                    1 -> app_mainactivity_bottomnavigationview.selectedItemId = R.id.item_tab2
                    2 -> app_mainactivity_bottomnavigationview.selectedItemId = R.id.item_tab3
                    3 -> app_mainactivity_bottomnavigationview.selectedItemId = R.id.item_tab4
                    4 -> app_mainactivity_bottomnavigationview.selectedItemId = R.id.item_tab5
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
    override fun initData() {
        //准备数据源
        var fragments:MutableList<Fragment> = mutableListOf(
            HomePageFragment(),
            SoftFragment(),
            DiscoverFragment(),
            CartFragment(),
            MineFragment()
        )
        app_mainactivity_viewpager.adapter = FragmentStateAdapter(
            supportFragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            fragments
        )
    }

}