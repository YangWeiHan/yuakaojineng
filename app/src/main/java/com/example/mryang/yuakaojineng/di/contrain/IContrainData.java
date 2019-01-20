package com.example.mryang.yuakaojineng.di.contrain;

import com.example.mryang.yuakaojineng.data.bean.GoodsBean;

public interface IContrainData {

    public interface IShowView{
        void setData(GoodsBean goodsBean);
    }

    public interface IShowPresenter<IShowView>{

        void attahView(IShowView iShowView);

        void detachView(IShowView iShowView);

        void goToRequestData();
    }

    public interface IShowModel{
        void contrainData(OnCallBack onCallBack);

        public interface OnCallBack{
            void onCallBack(GoodsBean goodsBean);
        }
    }
}
