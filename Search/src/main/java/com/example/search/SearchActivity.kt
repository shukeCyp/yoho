package com.example.search

import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mvpcore.annotation.MvpPresenter
import com.example.mvpcore.view.BaseActivity
import com.example.mvpcore.view.BaseMvpActivity
import com.example.search.contract.SearchContract
import com.example.search.model.entity.GoodsEntity
import com.example.search.presenter.SearchPresenterImpl
import kotlinx.android.synthetic.main.activity_search.*

@Route(path = "/Search/SearchActivity")
class SearchActivity : BaseMvpActivity<SearchPresenterImpl>(),SearchContract.SearchView{

    @MvpPresenter
    private lateinit var mPresenter : SearchPresenterImpl
    override fun IsClearStarBar(): Boolean {
        return true
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_search
    }

    override fun initEvent() {
        activity_search_editview.imeOptions = EditorInfo.IME_ACTION_DONE
        //设置单行输入
        activity_search_editview.setSingleLine()
        //按键监听
        activity_search_editview.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_DONE){
                    mPresenter.getSearchGoods(activity_search_editview.text.trim().toString(),"男")
                }
                return true
            }

        })

    }

    override fun initData() {
        activity_search_goodslist_recyclerview.layoutManager = LinearLayoutManager(this)
    }

    /**
     * 成功返回查找结果
     */
    override fun getGoodsSuccess(date: List<GoodsEntity>) {
        activity_search_goodslist_recyclerview.adapter = SearchGoodsAdapter(date)
    }

    /**
     * 失败返回异常信息
     */
    override fun getGoodsFaild(throwable: Throwable) {
        Log.i("TAG", "getGoodsFaild: ${throwable.localizedMessage}")
    }

}