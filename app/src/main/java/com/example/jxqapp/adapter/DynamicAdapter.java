package com.example.jxqapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jxqapp.R;
import com.example.jxqapp.bean.FriendDynamic;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder> {
    private List<FriendDynamic> mDynamicList;
    public DynamicAdapter(List<FriendDynamic> dynamicList){
        mDynamicList = dynamicList;
    }
    @NonNull
    @Override
    public DynamicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dynamic_item ,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicAdapter.ViewHolder holder, int position) {
        FriendDynamic friendDynamic = mDynamicList.get(position);
        holder.userImage.setImageResource(friendDynamic.getImageId());
        holder.userName.setText(friendDynamic.getUserName());
        holder.userDynamic.setText(friendDynamic.getDynamicContent());
        holder.dynamicTime.setText(friendDynamic.getDynamicTime());

    }

    @Override
    public int getItemCount() {
        return mDynamicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;
        TextView userDynamic;
        TextView dynamicTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = (ImageView) itemView.findViewById(R.id.user_image);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            userDynamic =(TextView) itemView.findViewById(R.id.user_content);
            dynamicTime = (TextView)itemView.findViewById(R.id.time_text);
        }
    }
}
