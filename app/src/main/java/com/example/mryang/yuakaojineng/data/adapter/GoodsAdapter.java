package com.example.mryang.yuakaojineng.data.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mryang.yuakaojineng.R;
import com.example.mryang.yuakaojineng.data.bean.GoodsBean;
import com.example.mryang.yuakaojineng.ui.fragment.consulview.JisuanView;

import java.util.List;

public class GoodsAdapter extends BaseQuickAdapter<GoodsBean.DataBean.ListBean,BaseViewHolder> {
    OnGoodsItemCheckListener onGoodsItemCheckListener;

    public void setOnGoodsItemCheckListener(OnGoodsItemCheckListener onGoodsItemCheckListener) {
        this.onGoodsItemCheckListener = onGoodsItemCheckListener;
    }

    public interface OnGoodsItemCheckListener {
        void onCallBack();
    }
    public GoodsAdapter(int layoutResId, @Nullable List<GoodsBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsBean.DataBean.ListBean item) {
        helper.setText(R.id.goods_name,item.getTitle());
        helper.setText(R.id.goods_price,item.getPrice()+"元");
        ImageView goods_icon = helper.getView(R.id.goods_icon);
        String images = item.getImages();
        String[] split = images.split("\\|");
        Glide.with(mContext).load(split[0]).into(goods_icon);
        CheckBox cb_goods = helper.getView(R.id.cb_goods);

        cb_goods.setOnCheckedChangeListener(null);
        cb_goods.setChecked(item.getGoodsCheck());
        cb_goods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setGoodsCheck(isChecked);
                if (onGoodsItemCheckListener != null){
                    onGoodsItemCheckListener.onCallBack();
                }
            }
        });

        JisuanView jisuanqi = helper.getView(R.id.jisuanqi);
        jisuanqi.setOnJisuanListener(new JisuanView.OnJisuanListener() {
            @Override
            public void add_jia(int number) {
                item.setNum(number);
                onGoodsItemCheckListener.onCallBack();
            }

            @Override
            public void decrease_jian(int number) {
                item.setNum(number);
                onGoodsItemCheckListener.onCallBack();
            }
        });


    }
}
