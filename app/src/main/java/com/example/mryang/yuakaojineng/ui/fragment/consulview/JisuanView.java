package com.example.mryang.yuakaojineng.ui.fragment.consulview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mryang.yuakaojineng.R;

public class JisuanView extends LinearLayout implements OnClickListener {


    private final Button btn_decrease;
    private final Button btn_add;
    private final TextView tv_number;

    public JisuanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        View view = LinearLayout.inflate(context, R.layout.jisuan_item,this);
        btn_decrease = view.findViewById(R.id.btn_decrease);
        btn_add = view.findViewById(R.id.btn_add);
        tv_number = view.findViewById(R.id.tv_number);
    }


    @Override
    public void onClick(View v) {
        String numberString = tv_number.getText().toString();
        int number = Integer.parseInt(String.valueOf(numberString));

        switch (v.getId()){
            case R.id.btn_decrease:
                number --;
                if (number < 0){
                    number = 0;
                    tv_number.setText(String.valueOf(number));
                }
                tv_number.setText(String.valueOf(number));
                onJisuanListener.decrease_jian(number);
                break;
            case R.id.btn_add:
                number ++;
                tv_number.setText(String.valueOf(number));
                onJisuanListener.add_jia(number);
                break;
        }
    }
    OnJisuanListener onJisuanListener;

    public void setOnJisuanListener(OnJisuanListener onJisuanListener) {
        this.onJisuanListener = onJisuanListener;
    }

    public interface OnJisuanListener{
        void add_jia(int number);
        void decrease_jian(int number);

    }
}
