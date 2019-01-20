package com.example.mryang.yuakaojineng.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mryang.yuakaojineng.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_zc)
    Button btnZc;
    @BindView(R.id.QQ_login)
    Button QQLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sharedPreferences = getSharedPreferences("RememberPass",MODE_PRIVATE);
        boolean jizhu = sharedPreferences.getBoolean("jizhu", false);
        if (jizhu){
            String rm_name = sharedPreferences.getString("RM_name", "");
            String rm_pass = sharedPreferences.getString("RM_pass", "");
            loginName.setText(rm_name);
            loginPassword.setText(rm_pass);
            cbRemember.setChecked(jizhu);
        }
    }

    @OnClick({R.id.btn_login, R.id.btn_zc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String login_name = loginName.getText().toString();
                String login_pass = loginPassword.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("jiazhu",cbRemember.isChecked());
                editor.putString("RM_name",login_name);
                editor.putString("RM_pass",login_pass);
                editor.commit();
                if (login_name.equals("1104894648")){
                    if (login_pass.equals("123456")){
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,ShowActivity.class));
                    }
                }
                break;
            case R.id.btn_zc:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }
}
