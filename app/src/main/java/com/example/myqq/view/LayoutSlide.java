package com.example.myqq.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myqq.R;

/**
 * Created by MangoWang on 2017/9/22.
 */

public class LayoutSlide extends FrameLayout{
    private Context context;

    private PicAndTextBtn dressUp;  // 装饰按钮
    private PicAndTextBtn profile; // 轮廓按钮
    private PicAndTextBtn setting; // 设置按钮
    private PicAndTextBtn night;  // 夜间模式按钮
    private boolean nightMode = false;  // 夜间信号值


    // 重写FrameLayout的构造方法
    public LayoutSlide(@NonNull Context context) {
        super(context);
        this.context = context;
        initViews();

    }

    public LayoutSlide(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initViews();
    }

    public LayoutSlide(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initViews();
    }

    private void initViews() {
        this.addView(LayoutInflater.from(context).inflate(R.layout.layout_slide, null));

        // 实例化控件
        dressUp = (PicAndTextBtn) findViewById(R.id.patb_dressup);
        profile = (PicAndTextBtn) findViewById(R.id.patb_profile);
        setting = (PicAndTextBtn) findViewById(R.id.patb_setting);
        night = (PicAndTextBtn) findViewById(R.id.patb_night);

        // 设置监听方法
        dressUp.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, AtyDressUp.class);
//                context.startActivity(intent);
            }
        });
//
        profile.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, AtyProfile.class);
//                context.startActivity(intent);
            }
        });
//
        setting.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, AtySetting.class);
//                context.startActivity(intent);
            }
        });
//
        night.setOnClickListener(new PicAndTextBtn.picAndTextBtnClickListener() {
            @Override
            public void onClick(View view) {

                if (nightMode) {
                    findViewById(R.id.layout_slide).setBackgroundColor(0xff878787);
                    nightMode = false;
                } else {
                    findViewById(R.id.layout_slide).setBackgroundColor(0xffe9e9e9);
                    nightMode = true;
                }
            }
        });

        //loadData();
    }
}
