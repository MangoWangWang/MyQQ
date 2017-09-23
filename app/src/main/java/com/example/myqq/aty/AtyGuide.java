package com.example.myqq.aty;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myqq.R;
import com.example.myqq.adapter.AdapterGuideViewPager;

import java.util.ArrayList;
import java.util.List;

public class AtyGuide extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    private ViewPager viewPager;  // ViewPager控件
    private AdapterGuideViewPager adapterGuideViewPager;  // viewPage控件
    private List<View> viewList;  //  视图列表
    private ImageView imageViews[] = new ImageView[3]; // 页面数组
    private int[] indicatorDotIds = {R.id.iv_indicator_dot1, R.id.iv_indicator_dot2, R.id.iv_indicator_dot3};  // 滚动点id
    private Button btnToMain; // 进入按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 全屏显示
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aty_guide);

        initView();
    }

    private void initView()
    {
        final LayoutInflater inflater = LayoutInflater.from(this);  // 系统默认的inflater
        // 加载数据
        viewList = new ArrayList<>();
        viewList.add(inflater.inflate(R.layout.guide_page1, null));
        viewList.add(inflater.inflate(R.layout.guide_page2, null));
        viewList.add(inflater.inflate(R.layout.guide_page3, null));

        // bind Id with imageView
        for (int i = 0; i < indicatorDotIds.length; i++) {
            imageViews[i] = (ImageView) findViewById(indicatorDotIds[i]);
        }

        // 创建ViewPager适配器
        adapterGuideViewPager = new AdapterGuideViewPager(viewList,this);

        // viewPager相关绑定
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        viewPager.setAdapter(adapterGuideViewPager);
        viewPager.addOnPageChangeListener(this);


        // 获取第三页中的button
        btnToMain = (Button) (viewList.get(2)).findViewById(R.id.btn_to_main);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到登陆注册页面
                Intent intent = new Intent(AtyGuide.this, AtyLoginOrRegister.class);
                startActivity(intent);
                AtyGuide.this.finish();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {

        // 根据页面移动改变下面的点(指示器实现)
        for (int i = 0; i < indicatorDotIds.length; i++) {
            if (i != position) {
                imageViews[i].setImageResource(R.drawable.unselected);
            } else {
                imageViews[i].setImageResource(R.drawable.selected);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
