package com.example.myqq.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MangoWang on 2017/9/23.
 */

public class UserItemMsg {

    private int iconID;
    private String userName;
    private String sign;
    private String state;


    public static List<UserItemMsg> userItemMsgsList = new ArrayList<>();

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }





}
