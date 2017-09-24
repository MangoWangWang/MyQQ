package com.example.myqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myqq.R;
import com.example.myqq.util.ImageManager;
import com.example.myqq.util.UserItemMsg;
import com.example.myqq.view.LayoutChats;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by MangoWang on 2017/9/23.
 */

public class AdapterUserItem extends RecyclerView.Adapter<AdapterUserItem.BaseViewHolder> {
    private Context context;
    private List<UserItemMsg> userItemMsgList; // 用户信息列表

    // adapter构造方法
    public AdapterUserItem(Context context,List<UserItemMsg> userItemMsgList)
    {
        this.context = context;
        this.userItemMsgList = userItemMsgList;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvatar; // 阿凡达imageView
        private TextView tvUserName;
        private TextView tvSign;

        public BaseViewHolder(View itemView) {
            super(itemView);
            // 持有这个控件的id
            ivAvatar = (ImageView)itemView.findViewById(R.id.iv_item_avatar);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_item_username);
            tvSign = (TextView) itemView.findViewById(R.id.tv_item_sign);

            // 设置每个item的点击方法
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 点击退出聊天对话页面
//                    Intent intent = new Intent(context, AtyChatRoom.class);
//                    intent.putExtra("username", tvUserName.getText().toString());
//                    context.startActivity(intent);

                    // 保存item中的用户信息
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


    // 创建ViewHolder是调用 onCreateViewHolder中负责为Item创建视图,onBindViewHolder负责将数据绑定到Item的视图上。
    @Override
    public AdapterUserItem.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(AdapterUserItem.BaseViewHolder holder, int position) {
        holder.ivAvatar.setImageResource(ImageManager.imagesAvatar[userItemMsgList.get(position).getIconID()]);
        holder.tvUserName.setText(userItemMsgList.get(position).getUserName());
        holder.tvSign.setText(userItemMsgList.get(position).getSign());
        holder.ivAvatar.setTag(userItemMsgList.get(position).getIconID());

    }

    @Override
    public int getItemCount() {
        return (userItemMsgList == null ? 0 : userItemMsgList.size());
    }
}
