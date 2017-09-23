package com.example.myqq.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.example.myqq.R;

/**
 * Created by MangoWang on 2017/9/23.
 */

public class PicAndTextBtn  extends LinearLayout {
    private Context context;

    /**
     * 布局控件
     */
    private ImageView imageView;
    private TextView textView;

    /**
     * 布局属性
     */
    private Drawable image;
    private Drawable imageBackground;
    private String text;
    private float textSize;
    private int textColor;
    private Drawable textBackground;


    /**
     * 自定义回调借口
     */

    interface picAndTextBtnClickListener {
        void onClick(View view);
    }
    private picAndTextBtnClickListener listener;

    public void setOnClickListener(picAndTextBtnClickListener listener) {
        this.listener = listener;
    }


    /**
     *
     * @param context 上下文
     * @param attrs 自定义attr文件
     */
    public PicAndTextBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        findAttrs(attrs);
        initViews();
        setPicAndTextBtnLayoutParams();
        setClickListener();
    }

    private void findAttrs(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PicAndTextBtn);
        image = typedArray.getDrawable(R.styleable.PicAndTextBtn_pic);
        imageBackground = typedArray.getDrawable(R.styleable.PicAndTextBtn_picBackground);
        text = typedArray.getString(R.styleable.PicAndTextBtn_text);
        textSize = typedArray.getDimension(R.styleable.PicAndTextBtn_textSize, 0);
        textColor = typedArray.getColor(R.styleable.PicAndTextBtn_textColor, 0);
        textBackground = typedArray.getDrawable(R.styleable.PicAndTextBtn_textBackground);
        typedArray.recycle();
    }

    private void initViews() {
        imageView = new ImageView(context);
        textView = new TextView(context);

        imageView.setImageDrawable(image);
        imageView.setBackground(imageBackground);

        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setTextColor(textColor);
        textView.setBackground(textBackground);

        textView.setGravity(Gravity.RIGHT);
    }

    private void setPicAndTextBtnLayoutParams() {

        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(20, 0, 0, 0);

        LayoutParams imageLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(imageView, imageLayoutParams);

        LayoutParams textViewLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView, textViewLayoutParams);
    }

    private void setClickListener() {
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });
    }
}
