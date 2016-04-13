package com.example.zzr.recyclerviewdemo.adapter;

import android.content.Context;

import com.example.zzr.recyclerviewdemo.R;
import com.example.zzr.recyclerviewdemo.bean.ChatMessage;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.MultiItemCommonAdapter;
import com.zhy.base.adapter.recyclerview.MultiItemTypeSupport;
import java.util.List;



public class ChatAdapterForRv extends MultiItemCommonAdapter<ChatMessage>
{
    public ChatAdapterForRv(Context context, List<ChatMessage> datas)
    {
        super(context, datas, new MultiItemTypeSupport<ChatMessage>()
        {
            @Override
            public int getLayoutId(int itemType)
            {
                if (itemType == ChatMessage.RECIEVE_MSG)
                {
                    return R.layout.main_chat_from_msg;
                } else
                    return R.layout.main_chat_send_msg;
            }

            @Override
            public int getItemViewType(int postion, ChatMessage msg)
            {
                if (msg.isComMeg())
                {
                    return ChatMessage.RECIEVE_MSG;
                }
                return ChatMessage.SEND_MSG;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, ChatMessage chatMessage)
    {

        switch (holder.getLayoutId())
        {
            case R.layout.main_chat_from_msg:
                holder.setText(R.id.chat_from_content, chatMessage.getContent());
                holder.setText(R.id.chat_from_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                break;
            case R.layout.main_chat_send_msg:
                holder.setText(R.id.chat_send_content, chatMessage.getContent());
                holder.setText(R.id.chat_send_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                break;
        }
    }
}
