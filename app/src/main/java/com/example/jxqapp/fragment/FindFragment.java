package com.example.jxqapp.fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jxqapp.Find1Activity;
import com.example.jxqapp.Find2Activity;
import com.example.jxqapp.Find3Activity;
import com.example.jxqapp.R;
import com.example.jxqapp.adapter.FindPagerAdapter;
import com.example.jxqapp.util.StaticUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class FindFragment extends Fragment{
    private static final int NUM_PAGES = 3;
    private ViewPager findPager;
    private TabLayout tabLayout;
//    private View find1,find2,find3;
    private ArrayList<View> viewArrayList = null;
    private FindPagerAdapter pagerAdapter = null;
    private static FindFragment ff;
    //单例模式
    public static FindFragment getFindFragment()
    {
        if(ff == null){
            ff = new FindFragment();
        }
        return ff;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findPager =(ViewPager) this.getActivity().findViewById(R.id.findd_viewpager);
        tabLayout =(TabLayout) this.getActivity().findViewById(R.id.tab_layout);
        /**
         *      获取三个布局文件，生成 View 对象
         */

        //  让 PagerAdapter 梳理一下这些 view界面 的数据源，将 viewArrayList 集合传入
        pagerAdapter = new FindPagerAdapter(getChildFragmentManager(),1);
        //  最后给 viewPager 设置数据源
        if (StaticUtil.userType==1){
            pagerAdapter.AddFragemnt(new Find1Activity(),"班级");
            pagerAdapter.AddFragemnt(new Find2Activity(),"企业");
            pagerAdapter.AddFragemnt(new Find3Activity(),"查找");
        }else if (StaticUtil.userType==2){
            pagerAdapter.AddFragemnt(new Find1Activity(),"班级");
            pagerAdapter.AddFragemnt(new Find2Activity(),"企业");
            pagerAdapter.AddFragemnt(new Find3Activity(),"查找");
        }else if (StaticUtil.userType==3){
            pagerAdapter.AddFragemnt(new Find1Activity(),"孩子");
            pagerAdapter.AddFragemnt(new Find2Activity(),"老师");
            pagerAdapter.AddFragemnt(new Find3Activity(),"查找");
        }else if (StaticUtil.userType==4){
            pagerAdapter.AddFragemnt(new Find1Activity(),"班级");
            pagerAdapter.AddFragemnt(new Find2Activity(),"企业");
            pagerAdapter.AddFragemnt(new Find3Activity(),"查找");
        }

        findPager.setAdapter(pagerAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_find_fragment ,container, false);
        return view;
    }
}
