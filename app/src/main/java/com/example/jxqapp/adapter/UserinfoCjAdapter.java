package com.example.jxqapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jxqapp.R;
import com.example.jxqapp.bean.Chengji;
import com.example.jxqapp.bean.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class UserinfoCjAdapter extends ArrayAdapter<Chengji> {
    private int resourceId;
    public UserinfoCjAdapter(@NonNull Context context,int textViewResourceId, @NonNull List<Chengji> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Chengji chengji = getItem(position);
        View view;
        UserinfoCjAdapter.ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new UserinfoCjAdapter.ViewHolder();
            viewHolder.course_name = view.findViewById(R.id.cj_name);
            viewHolder.mark= view.findViewById(R.id.ci_mark);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (UserinfoCjAdapter.ViewHolder) view.getTag();
        }
        viewHolder.course_name.setText(chengji.getCourse_name());
        viewHolder.mark.setText(""+chengji.getCourse_mark());
        return  view;
    }

    public class ViewHolder {
        TextView course_name;
        TextView mark;
    }

}
