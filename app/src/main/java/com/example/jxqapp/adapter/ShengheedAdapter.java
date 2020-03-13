package com.example.jxqapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jxqapp.ChatAdapter;
import com.example.jxqapp.R;
import com.example.jxqapp.bean.ChatItem;
import com.example.jxqapp.bean.ShengheItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ShengheedAdapter extends ArrayAdapter {
    private int resourceId;
    public ShengheedAdapter(Context context, int textViewResourceId, @NonNull List<ShengheItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ShengheItem shenghe = (ShengheItem) getItem(position);
        View view;
        ShengheedAdapter.ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.shengheImage = (ImageView) view.findViewById(R.id.shenghe_image);
            viewHolder.shengheName = (TextView) view.findViewById(R.id.shenghe_name);
            viewHolder.shengheTitle = (TextView) view.findViewById(R.id.shenghe_content);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.shengheName.setText(shenghe.getName());
        viewHolder.shengheTitle.setText(shenghe.getTitle());
        //更改item的图片
        ImageView imageView = view.findViewById(R.id.shenghe_image1);
        imageView.setBackgroundResource(R.drawable.shengheing);
     //   viewHolder.shengheImage.setText(chatItem.getTime());
        return view;
    }

    public class ViewHolder {
        TextView shengheName;
        TextView shengheTitle;
        ImageView shengheImage;
    }
}
