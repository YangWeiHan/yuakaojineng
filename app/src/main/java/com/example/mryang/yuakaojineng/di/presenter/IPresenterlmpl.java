package com.example.mryang.yuakaojineng.di.presenter;

import com.example.mryang.yuakaojineng.data.bean.GoodsBean;
import com.example.mryang.yuakaojineng.di.contrain.IContrainData;
import com.example.mryang.yuakaojineng.di.model.IShowModellmpl;

import java.lang.ref.SoftReference;

public class IPresenterlmpl implements IContrainData.IShowPresenter<IContrainData.IShowView> {
    IContrainData.IShowView iShowView;
    private SoftReference<IContrainData.IShowView> reference;
    private IShowModellmpl modellmpl;

    @Override
    public void attahView(IContrainData.IShowView iShowView) {
        this.iShowView = iShowView;
        reference = new SoftReference<>(iShowView);
        modellmpl = new IShowModellmpl();
    }

    @Override
    public void detachView(IContrainData.IShowView iShowView) {
        reference.clear();
    }

    @Override
    public void goToRequestData() {
        modellmpl.contrainData(new IContrainData.IShowModel.OnCallBack() {
            @Override
            public void onCallBack(GoodsBean goodsBean) {
                iShowView.setData(goodsBean);
            }
        });

    }
}
