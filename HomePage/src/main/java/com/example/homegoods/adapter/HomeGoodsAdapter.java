package com.example.homegoods.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.homegoods.model.entity.GoodsEntity;
import com.example.homepage.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public
/**
 *   @Author:YaPeng
 *   @Date:2021/8/4
 *   @Email:3536815334@qq.com
 */
class HomeGoodsAdapter extends BaseQuickAdapter<GoodsEntity, BaseViewHolder> {
    public HomeGoodsAdapter(@Nullable List<GoodsEntity> data) {
        super(R.layout.home_recycler_item_layout, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, GoodsEntity goodsEntity) {
        Log.i("TAG", getContext().toString());
        Glide.with(getContext()).load(goodsEntity.getPictUrl()).into((ImageView) baseViewHolder.findView(R.id.rec_item_img));
        baseViewHolder.setText(R.id.rec_item_txt, "                           "+goodsEntity.getTitle());
    }
}
