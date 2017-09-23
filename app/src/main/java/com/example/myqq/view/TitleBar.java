package com.example.myqq.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myqq.R;

/**
 * Created by MangoWang on 2017/9/23.
 */

public class TitleBar extends RelativeLayout {

    private Context context;

    /**
     * 布局控件
     */
    private Button btnLeft; // 左按钮
    private Button btnRight; // 右按钮
    private TextView tvTitle;  // 中间标题

    /**
     * title控件对应的自定义属性
     */
    private String titleText;
    private float titleTextSize;
    private int titleTextColor;
    private Drawable titleBackground;

    /**
     * left控件对应的自定义属性
     */
    private String leftText;
    private float leftTextSize;
    private int leftTextColor;
    private Drawable leftBackground;

    /**
     * right控件对应的自定义属性
     */
    private String rightText;
    private float rightTextSize;
    private int rightTextColor;
    private Drawable rightBackground;


    /**
     * 内部接口的定义
     */
    public interface titleBarClickListener
    {
        void leftButtonClick();
        void rightButtonClick();
    }

    private titleBarClickListener listener;

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        findAttrs(attrs);
        initView();
        setTitleBarLayoutParams();
        setButtonClickListener();
    }

    private void findAttrs(AttributeSet attrs) {
        //obtain 获得 参数二为自定义的styleable名称 
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar); // 获得type属性数组

        // 获取xml文件中的属性
        leftText = typedArray.getString(R.styleable.TitleBar_leftText);
        leftTextSize = typedArray.getDimension(R.styleable.TitleBar_leftTextSize,24); // 参数二为默认值
        leftTextColor = typedArray.getColor(R.styleable.TitleBar_leftTextColor,0);
        leftBackground = typedArray.getDrawable(R.styleable.TitleBar_leftBackground);

        titleText = typedArray.getString(R.styleable.TitleBar_titleText);
        titleTextSize = typedArray.getDimension(R.styleable.TitleBar_titleTextSize,24); // 参数二为默认值
        titleTextColor = typedArray.getColor(R.styleable.TitleBar_titleTextColor,0);
        titleBackground = typedArray.getDrawable(R.styleable.TitleBar_titleBackground);

        rightText = typedArray.getString(R.styleable.TitleBar_rightText);
        rightTextSize = typedArray.getDimension(R.styleable.TitleBar_rightTextSize,24); // 参数二为默认值
        rightTextColor = typedArray.getColor(R.styleable.TitleBar_rightTextColor,0);
        rightBackground = typedArray.getDrawable(R.styleable.TitleBar_rightBackground);

        // 回收typeArray的缓存
        typedArray.recycle();


    }

    private void initView() {
        //1.实例化控件
        btnLeft = new Button(context);
        tvTitle = new TextView(context);
        btnRight = new Button(context);

        // 2.设置属性
        btnLeft.setText(leftText);
        btnLeft.setTextColor(leftTextColor);
        btnLeft.setTextSize(leftTextSize);
        btnLeft.setBackground(leftBackground);

        tvTitle.setText(titleText);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setBackground(titleBackground);
        tvTitle.setGravity(Gravity.CENTER);

        btnRight.setText(rightText);
        btnRight.setTextColor(rightTextColor);
        btnRight.setTextSize(rightTextSize);
        btnRight.setBackground(rightBackground);

        // 设置bar的背景颜色
        setBackgroundColor(0xFF01AAFF);

    }

    private void  setTitleBarLayoutParams() {
        btnLeft.setAllCaps(false);// 设置全部不为大写
        btnRight.setAllCaps(false);

        // 设置titleBar自带属性
        LayoutParams btnLeftLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        btnLeftLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        // 将控件整合属性一起添加到view上
        addView(btnLeft,btnLeftLayoutParams);

        LayoutParams btnRightLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        btnRightLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(btnRight,btnRightLayoutParams);

        LayoutParams titleLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(tvTitle, titleLayoutParams);
    }

    private void setButtonClickListener() {
        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.leftButtonClick();
            }
        });
        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.rightButtonClick();
            }
        });
    }
}

























