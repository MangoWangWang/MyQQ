package com.example.myqq.aty;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TableLayout;

import com.example.myqq.R;
import com.example.myqq.adapter.AdapterMainViewPager;
import com.example.myqq.view.LayoutChats;
import com.example.myqq.view.LayoutContacts;
import com.example.myqq.view.LayoutMoments;

import java.util.ArrayList;
import java.util.List;

public class AtyMain extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<TabLayout.Tab> tabList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aty_main);
        initViews();
    }

    private void initViews()
    {

        // 实例化控件
        viewPager = (ViewPager) findViewById(R.id.vp_main);
        tabLayout = (TabLayout) findViewById(R.id.tl_main);


        // tab标签集合
        tabList = new ArrayList<>();
        AdapterMainViewPager adapter = new AdapterMainViewPager(getSupportFragmentManager());
        // 填充fragment
        adapter.addFragment(new LayoutChats());
        adapter.addFragment(new LayoutContacts());
        adapter.addFragment(new LayoutMoments());
        viewPager.setAdapter(adapter);
        // 将viewpager与tablayout绑定
        tabLayout.setupWithViewPager(viewPager);
        // 取出tablayout中的tab标签集合
        tabList.add(tabLayout.getTabAt(0));
        tabList.add(tabLayout.getTabAt(1));
        tabList.add(tabLayout.getTabAt(2));
        // 修改其中的属性
        tabList.get(0).setIcon(R.drawable.icon).setText("Chats");
        tabList.get(1).setIcon(R.drawable.icon).setText("Contacts");
        tabList.get(2).setIcon(R.drawable.icon).setText("Moments");
    }
}
