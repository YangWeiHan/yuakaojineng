package com.example.mryang.yuakaojineng.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mryang.yuakaojineng.R;
import com.example.mryang.yuakaojineng.data.adapter.BusionessAdapter;
import com.example.mryang.yuakaojineng.data.bean.GoodsBean;
import com.example.mryang.yuakaojineng.di.contrain.IContrainData;
import com.example.mryang.yuakaojineng.di.presenter.IPresenterlmpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShoppingCarFragment extends Fragment implements IContrainData.IShowView,View.OnClickListener {

    @BindView(R.id.rv_recyclerView)
    RecyclerView rvRecyclerView;
    @BindView(R.id.cb_all)
    CheckBox cbAll;
    @BindView(R.id.all_price)
    TextView allPrice;
    Unbinder unbinder;
    private IPresenterlmpl iPresenterlmpl;
    private List<GoodsBean.DataBean> busioness_data;
    private BusionessAdapter busionessAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopcar, container, false);
        iPresenterlmpl = new IPresenterlmpl();
        iPresenterlmpl.attahView(this);
        iPresenterlmpl.goToRequestData();
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    private void jisuanPrece(){
        double tatolPrice = 0;
        for (int i = 0; i < busioness_data.size(); i++) {
            for (int j = 0; j < busioness_data.get(i).getList().size(); j++) {
                if (busioness_data.get(i).getList().get(j).getGoodsCheck()){
                    double price = busioness_data.get(i).getList().get(j).getPrice();
                    int num = busioness_data.get(i).getList().get(j).getNum();
                    tatolPrice = tatolPrice + (price * num);
                }
            }
        }
        allPrice.setText("合计：￥："+String.valueOf(tatolPrice));

    }

    @Override
    public void setData(GoodsBean goodsBean) {
        cbAll.setOnCheckedChangeListener(null);
        cbAll.setOnClickListener(this);
        busioness_data = goodsBean.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvRecyclerView.setLayoutManager(linearLayoutManager);
        busionessAdapter = new BusionessAdapter(R.layout.busioness_item, busioness_data);
        rvRecyclerView.setAdapter(busionessAdapter);

        busionessAdapter.setOnBusionessItemCheckListener(new BusionessAdapter.OnBusionessItemCheckListener() {
            @Override
            public void onCallBack() {
                boolean tesulter = true;
                for (int i = 0; i < busioness_data.size(); i++) {
                    boolean busionessCheck = busioness_data.get(i).getBusionessCheck();
                    tesulter = tesulter & busionessCheck;
                    for (int j = 0; j < busioness_data.get(i).getList().size(); j++) {
                        boolean goodsCheck = busioness_data.get(i).getList().get(j).getGoodsCheck();
                        tesulter = tesulter & goodsCheck;
                    }
                }
                cbAll.setChecked(tesulter);
                jisuanPrece();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPresenterlmpl.detachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i <busioness_data.size(); i++) {
            busioness_data.get(i).setBusionessCheck(cbAll.isChecked());
            for (int j = 0; j < busioness_data.get(i).getList().size(); j++) {
                busioness_data.get(i).getList().get(j).setGoodsCheck(cbAll.isChecked());
            }
        }
        busionessAdapter.notifyDataSetChanged();
        jisuanPrece();
    }
}
