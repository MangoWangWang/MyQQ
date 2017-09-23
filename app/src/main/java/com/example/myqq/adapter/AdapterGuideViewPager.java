package com.example.myqq.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by MangoWang on 2017/9/22.
 */

public class AdapterGuideViewPager extends PagerAdapter {

    private List<View> viewList;  // 引导页列表
    private Context mContent;  // guide上下文


    // 默认构造函数,构造是提供必要的数据
    public AdapterGuideViewPager (List<View> viewList,Context mContent)
    {
        this.viewList = viewList;
        this.mContent = mContent;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }
}
