package com.example.mryang.yuakaojineng.data.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mryang.yuakaojineng.R;
import com.example.mryang.yuakaojineng.data.bean.GoodsBean;
import java.util.List;

public class BusionessAdapter extends BaseQuickAdapter<GoodsBean.DataBean,BaseViewHolder> {
    OnBusionessItemCheckListener onBusionessItemCheckListener;
    public void setOnBusionessItemCheckListener(OnBusionessItemCheckListener onBusionessItemCheckListener) {
        this.onBusionessItemCheckListener = onBusionessItemCheckListener;
    }
    public interface OnBusionessItemCheckListener {
        void onCallBack();
    }
    public BusionessAdapter(int layoutResId, @Nullable List<GoodsBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsBean.DataBean item) {
        helper.setText(R.id.busioness_name,item.getSellerName());
        final CheckBox cb_busioness = helper.getView(R.id.cb_busioness);
        RecyclerView good_recyclerView = helper.getView(R.id.goods_recyclerView);

        final List<GoodsBean.DataBean.ListBean> goods_data = item.getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        good_recyclerView.setLayoutManager(linearLayoutManager);
        final GoodsAdapter goodsAdapter = new GoodsAdapter(R.layout.goods_item, goods_data);
        good_recyclerView.setAdapter(goodsAdapter);

        cb_busioness.setOnCheckedChangeListener(null);
        cb_busioness.setChecked(item.getBusionessCheck());

        goodsAdapter.setOnGoodsItemCheckListener(new GoodsAdapter.OnGoodsItemCheckListener() {
            @Override
            public void onCallBack() {
                boolean resulter = true;
                //只要有一个条目未选中
                for (int i = 0; i < item.getList().size(); i++) {
                    resulter = resulter & item.getList().get(i).getGoodsCheck();
                }
                cb_busioness.setChecked(resulter);
                goodsAdapter.notifyDataSetChanged();
                onBusionessItemCheckListener.onCallBack();
            }
        });

        cb_busioness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < item.getList().size(); i++) {
                    item.getList().get(i).setGoodsCheck(cb_busioness.isChecked());
                }
                item.setBusionessCheck(cb_busioness.isChecked());
                notifyDataSetChanged();
                onBusionessItemCheckListener.onCallBack();

            }
        });



    }
}
