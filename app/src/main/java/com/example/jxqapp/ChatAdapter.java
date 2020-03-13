package com.example.jxqapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jxqapp.bean.ChatItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChatAdapter extends ArrayAdapter<ChatItem> {
    private int resourceId;
    public ChatAdapter(Context context, int textViewResourceId, @NonNull List<ChatItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ChatItem chatItem = getItem(position);//获取当前项的item实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.chatImage = (ImageView) view.findViewById(R.id.chat_image);
            viewHolder.chatName = (TextView) view.findViewById(R.id.chat_name);
            viewHolder.chatContent = (TextView) view.findViewById(R.id.chat_content);
            viewHolder.chatTime = (TextView) view.findViewById(R.id.chat_time);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


      //  chatImage.setImageResource(chatItem.getImgstr());
        viewHolder.chatName.setText(chatItem.getName());
        viewHolder.chatContent.setText(chatItem.getContent());
        viewHolder. chatTime.setText(chatItem.getTime());
        return view;
    }
    class ViewHolder{
        ImageView chatImage;
        TextView chatName;
        TextView chatContent;
        TextView chatTime;

    }
}
