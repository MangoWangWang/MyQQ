package com.example.myqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myqq.R;
import com.example.myqq.util.UserItemMsg;
import com.example.myqq.view.LayoutChats;

import java.util.List;

/**
 * Created by MangoWang on 2017/9/23.
 */

public class AdapterUserItem extends RecyclerView.Adapter<AdapterUserItem.BaseViewHolder> {
    private Context context;

    private List<UserItemMsg> userItemMsgList; // 用户信息列表

    class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar; // 阿凡达imageView
        private TextView tvUserName;
        private TextView tvSign;

        public BaseViewHolder(View itemView) {
            super(itemView);
            ivAvatar = (ImageView)itemView.findViewById(R.id.iv_item_avatar);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_item_username);
            tvSign = (TextView) itemView.findViewById(R.id.tv_item_sign);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 点击退出聊天对话页面
                    Intent intent = new Intent(context, AtyChatRoom.class);
                    intent.putExtra("username", tvUserName.getText().toString());
                    context.startActivity(intent);



                    UserItemMsg userItemMsg = new UserItemMsg();
                    userItemMsg.setSign(tvSign.getText().toString());
                    userItemMsg.setIconID((Integer) ivAvatar.getTag());
                    userItemMsg.setUserName(tvUserName.getText().toString());


                    for (UserItemMsg item : LayoutChats.userItemMsgList) {
                        if (item.getUserName().equals(userItemMsg.getUserName())) {
                            return;
                        }
                    }
                    LayoutChats.userItemMsgList.add(userItemMsg);
                    UserItemMsg.userItemMsgsList.add(userItemMsg);
                }
            });
        }
    }


    @Override
    public AdapterUserItem.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterUserItem.BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
