package com.example.mryang.yuakaojineng.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mryang.yuakaojineng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_btn)
    Button registerBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.register_btn)
    public void onViewClicked() {
        String login_name = registerName.getText().toString();
        String login_pass = registerPassword.getText().toString();


        if (login_name.equals("1104894648")){
            if (login_pass.equals("123456")){
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        }

    }
}
