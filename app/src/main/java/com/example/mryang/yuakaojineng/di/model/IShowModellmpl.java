package com.example.mryang.yuakaojineng.di.model;

import com.bumptech.glide.Glide;
import com.example.mryang.yuakaojineng.data.aplis.Apils;
import com.example.mryang.yuakaojineng.data.bean.GoodsBean;
import com.example.mryang.yuakaojineng.di.contrain.IContrainData;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class IShowModellmpl implements IContrainData.IShowModel {
    @Override
    public void contrainData(final OnCallBack onCallBack) {
        OkGo.<String>get(Apils.GOODS_URL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                GoodsBean goodsBean = gson.fromJson(responseData, GoodsBean.class);
                onCallBack.onCallBack(goodsBean);
            }
        });
    }
}
