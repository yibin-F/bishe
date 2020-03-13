package com.example.jxqapp.myfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.jxqapp.R;
import com.example.jxqapp.adapter.FindPagerAdapter;
import com.example.jxqapp.shenghe.ShengheedActivity;
import com.example.jxqapp.shenghe.ShengheingActivity;
import com.google.android.material.tabs.TabLayout;

public class ShengheActivity extends AppCompatActivity {
    private ViewPager shenghePager;
    private TabLayout tabLayout;
    private FindPagerAdapter pagerAdapter = null;
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        shenghePager = this.getActivity().findViewById(R.id.shenghe_viewpager);
//        tabLayout = this.getActivity().findViewById(R.id.shenghe_tab);
//
//        pagerAdapter = new FindPagerAdapter(getChildFragmentManager(),1);
//        pagerAdapter.AddFragemnt(new ShengheingActivity(),"未审核");
//        pagerAdapter.AddFragemnt(new ShengheedActivity(),"已审核");
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_shenghe,container, false);
//        return view;
//    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenghe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        shenghePager = findViewById(R.id.shenghe_viewpager);
        tabLayout = findViewById(R.id.shenghe_tab);

        pagerAdapter = new FindPagerAdapter(getSupportFragmentManager(),1);
        pagerAdapter.AddFragemnt(new ShengheingActivity(),"未审核");
        pagerAdapter.AddFragemnt(new ShengheedActivity(),"已审核");

        shenghePager.setAdapter(pagerAdapter);
    }
}
