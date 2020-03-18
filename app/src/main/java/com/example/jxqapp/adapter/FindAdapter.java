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
import com.example.jxqapp.bean.FindItem;
import com.example.jxqapp.bean.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FindAdapter extends ArrayAdapter<Student> {
    private int resourceId;
    public FindAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Student> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);//获取当前项的item实例
        View view;
        FindAdapter.ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new FindAdapter.ViewHolder();
            viewHolder.findName = (TextView) view.findViewById(R.id.find_name);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (FindAdapter.ViewHolder) view.getTag();
        }


        //  chatImage.setImageResource(chatItem.getImgstr());
        viewHolder.findName.setText(student.getUser_name());

        return view;
    }
    class ViewHolder {
        TextView findName;
    }
}
