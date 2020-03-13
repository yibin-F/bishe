package com.example.jxqapp.shenghe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.jxqapp.R;
import com.example.jxqapp.adapter.ShengheedAdapter;
import com.example.jxqapp.bean.ShengheItem;

import java.util.ArrayList;
import java.util.List;

public class ShengheingActivity extends Fragment implements AdapterView.OnItemClickListener {
    private static List<ShengheItem> shengheItemList = new ArrayList<>();
    public ShengheingActivity(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shengheing,container, false);


        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initShenhe();
        ShengheedAdapter shengheedAdapter = new ShengheedAdapter(this.getActivity(),R.layout.shenghe_item,shengheItemList);
        //给布局中的加图片

        ListView listView = this.getActivity().findViewById(R.id.shengheing_list);
        listView.setOnItemClickListener(this);
        listView.setAdapter(shengheedAdapter);
    }
    private void initShenhe() {
        shengheItemList.clear();
        ShengheItem a1 = new ShengheItem("小红","英语四六级");
        shengheItemList.add(a1);
        ShengheItem a2 = new ShengheItem("小刚","计算机二级");
        shengheItemList.add(a2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ShengheItem shengheItem = shengheItemList.get(position);
        Intent intent = new Intent(this.getActivity(), ShengheContentActivity.class);
        startActivity(intent);
    }
}
