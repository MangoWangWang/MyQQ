package com.example.myqq.aty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.myqq.R;

public class AtyWelcome extends AppCompatActivity {

    private static final int DELAY = 2000;
    private static final int GO_GUIDE = 0;
    private static final int GO_HOME = 1;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE: {
                    goGuide();
                    break;
                }
                case GO_HOME: {
                    goHome();
                    break;
                }
                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 启动全屏通用代码
          */
        // 隐藏actionBar
        getSupportActionBar().hide();
        // 设置窗体全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aty_welcome);
        initLoad();
    }

    private void initLoad()
    {
        // 创建名为myqq的SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("myqq",MODE_PRIVATE); //为默认操作模式,代表该文件是私有数据,只能被应用本身访问,在该模式下,写入的内容会覆盖原文件的内容
        boolean guide = sharedPreferences.getBoolean("guide",true); // 在SharedPreferences中取出guide,没有时返回true
        if (!guide) {
            handler.sendEmptyMessageDelayed(GO_HOME, DELAY);

        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE, DELAY); // 延期两秒后给系统发一条消息
            // 存储到SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.apply();
        }

    }

    // 跳转到登陆或注册页面
    private void goHome()
    {
        Intent intent = new Intent(this, AtyLoginOrRegister.class);
        startActivity(intent);
        finish();
    }

    // 跳转到引导页面
    private void goGuide()
    {
        Intent intent = new Intent(this, AtyGuide.class);
        startActivity(intent);
        finish();
    }

}
