package com.example.mryang.yuakaojineng.ui.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mryang.yuakaojineng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainPagerFragment extends Fragment {
    @BindView(R.id.text_suxingAnimtor)
    TextView textSuxingAnimtor;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.text_suxingAnimtor)
    public void onViewClicked() {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(textSuxingAnimtor, "scaleY", 1f, 2f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(textSuxingAnimtor, "scaleX", 1f, 2f);
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(textSuxingAnimtor, "rotationY", 0, 180);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX,scaleY,rotationY);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }
}
