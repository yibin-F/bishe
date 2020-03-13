package com.example.jxqapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jxqapp.adapter.FindAdapter;
import com.example.jxqapp.bean.ChatItem;
import com.example.jxqapp.bean.FindItem;
import com.example.jxqapp.fragment.ChatFragment;
import com.example.jxqapp.fragment.FindFragment;

import java.util.ArrayList;
import java.util.List;

public class Find1Activity extends Fragment implements AdapterView.OnItemClickListener {
    private List<FindItem> findList = new ArrayList<>();
    private static Find1Activity mf;
    //单例模式
    public static Find1Activity getFind1Activity()
    {
        if(mf == null){
            mf = new Find1Activity();
        }
        return mf;
    }
   public Find1Activity(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_find1,container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFind();
        FindAdapter findadapter = new FindAdapter(this.getActivity(),R.layout.find_item,findList);
       ListView listView = (ListView)this.getActivity().findViewById(R.id.banji_list);
       listView.setOnItemClickListener(this);
        listView.setAdapter(findadapter);
    }

    private void initFind() {
        findList.clear();
        FindItem a1 = new FindItem("小刚");
        findList.add(a1);
        FindItem a2 = new FindItem("小红");
        findList.add(a2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FindItem findItem = findList.get(position);
        Toast.makeText(this.getActivity(),"545dfs",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this.getActivity(), UserInfoActivity.class);
        startActivity(intent);
    }
}
