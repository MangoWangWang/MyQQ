package com.example.myqq.aty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.myqq.R;

public class AtyLoginOrRegister extends AppCompatActivity  implements View.OnClickListener{

    private TabHost tabHost; // 选项卡

    private Button btnLogin; // 登陆按钮
    private EditText etLoginUsername;  // 用户名
    private EditText etLoginPassword;  // 密码

    private Button btnRegister;  // 注册按钮
    private EditText etRegisterUsername;  // 注册用户名
    private EditText etRegisterPassword;  // 注册密码
    private EditText etInsurePassword;  // 注册确认密码

    //private ServerManager serverManager = ServerManager.getServerManager();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aty_login_or_register);
        initViews();
    }

    private void initViews() {
        // 实例化控件
        tabHost = (TabHost) findViewById(R.id.tabHost);

        btnLogin = (Button) findViewById(R.id.btn_login);
        etLoginUsername = (EditText) findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);

        btnRegister = (Button) findViewById(R.id.btn_register);
        etRegisterUsername = (EditText) findViewById(R.id.et_register_username);
        etRegisterPassword = (EditText) findViewById(R.id.et_register_password);
        etInsurePassword = (EditText) findViewById(R.id.et_insure_password);

        // 安装tabHost
        tabHost.setup();
        // tabHost中添加tab
        tabHost.addTab(tabHost.newTabSpec("Login").setIndicator("Login").setContent(R.id.layout_login));
        tabHost.addTab(tabHost.newTabSpec("Register").setIndicator("Register").setContent(R.id.layout_register));

        // 设置选项卡内标签的属性
        for (int i = 0; i < 2; i++) {
            TextView tv = ((TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title));
            tv.setAllCaps(false);
            tv.setTextSize(16);
        }

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        //serverManager.start();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login: {
                Intent intent = new Intent(this, AtyMain.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.btn_register: {
                Intent intent = new Intent(this, AtyMain.class);
                startActivity(intent);
                finish();
                break;
            }
            default:
                break;
        }
    }
}
