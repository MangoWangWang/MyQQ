package com.example.myqq.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myqq.R;
import com.example.myqq.util.UserItemMsg;

import java.util.List;

/**
 * Created by MangoWang on 2017/9/22.
 */

public class LayoutChats extends Fragment {

    private View rootView;

    public static List<UserItemMsg> userItemMsgList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.layout_chats, container, false);
        return rootView;
    }
}
