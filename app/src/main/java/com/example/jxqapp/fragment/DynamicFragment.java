package com.example.jxqapp.fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jxqapp.R;
import com.example.jxqapp.adapter.DynamicAdapter;
import com.example.jxqapp.bean.FriendDynamic;

import java.util.ArrayList;
import java.util.List;

public class DynamicFragment extends Fragment {
    private List<FriendDynamic> dynamicList = new ArrayList<>();
    private static DynamicFragment df;
    //单例模式
    public static DynamicFragment getDynamicFragment()
    {
        if(df == null){
            df = new DynamicFragment();
        }
        return df;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDynamic();
        RecyclerView recyclerView = this.getActivity().findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        DynamicAdapter adapter = new DynamicAdapter(dynamicList);
        recyclerView.setAdapter(adapter);
    }

    private void initDynamic() {
        dynamicList.clear();
        FriendDynamic dynamic1 = new FriendDynamic("小刚","今天去爬山了",R.drawable.touxiang1,"5:10");
        dynamicList.add(dynamic1);
        FriendDynamic dynamic2 = new FriendDynamic("小红","今天去游泳了",R.drawable.touxiang2,"6:10");
        dynamicList.add(dynamic2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dynamic_fragment ,container, false);
        return view;
    }
}
