package com.example.search;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.search.model.entity.GoodsEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


/**
 *   @Author:YaPeng
 *   @Date:2021/7/31
 *   @Email:3536815334@qq.com
 */
public class SearchGoodsAdapter extends BaseQuickAdapter<GoodsEntity, BaseViewHolder> {

    public SearchGoodsAdapter(@Nullable List<GoodsEntity> data) {
        super(R.layout.search_recycle_item_layout, data);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, GoodsEntity goodsEntity) {
        Glide.with(getContext()).load(goodsEntity.getPictUrl()).into((ImageView) baseViewHolder.findView(R.id.search_goods_item_image));
        baseViewHolder.setText(R.id.search_goods_item_price,goodsEntity.getReservePrice());
        baseViewHolder.setText(R.id.search_goods_item_title,goodsEntity.getTitle());
    }
}
