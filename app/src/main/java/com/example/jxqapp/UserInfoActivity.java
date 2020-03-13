package com.example.jxqapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jxqapp.adapter.FindPagerAdapter;
import com.example.jxqapp.info_fragment.UserCjFragment;
import com.example.jxqapp.info_fragment.UserInfoFragment;
import com.example.jxqapp.info_fragment.UserZsFragment;
import com.google.android.material.tabs.TabLayout;

public class UserInfoActivity extends AppCompatActivity{

    private ViewPager userinfoPager;
    private TabLayout tabLayout;
    private FindPagerAdapter pagerAdapter = null;
    public UserInfoActivity(){}
//    private static UserInfoActivity ua;
//    public  static UserInfoActivity getUserInfoActivity(){
//        if(ua == null){
//            ua = new UserInfoActivity();
//        }
//        return ua;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        userinfoPager = this.getActivity().findViewById(R.id.userinfo_pager);
//        tabLayout = this.getActivity().findViewById(R.id.user_info_table);
//
//        pagerAdapter = new FindPagerAdapter(getChildFragmentManager(),1);
//        pagerAdapter.AddFragemnt(new UserCjFragment(),"成绩");
//        pagerAdapter.AddFragemnt(new UserZsFragment(),"证书");
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_user_info,container, false);
//        return view;
//    }
        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
//        getSupportFragmentManager().beginTransaction().add(R.id.info_fram,new UserInfoFragment())
//        .commit();
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();
        userinfoPager = findViewById(R.id.userinfo_pager);
        tabLayout = findViewById(R.id.user_info_table);

        pagerAdapter = new FindPagerAdapter(getSupportFragmentManager(),1);
        pagerAdapter.AddFragemnt(new UserCjFragment(),"成绩");
        pagerAdapter.AddFragemnt(new UserZsFragment(),"证书");

        userinfoPager.setAdapter(pagerAdapter);

    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_info);
//        userinfoPager = findViewById(R.id.userinfo_pager);
//        tabLayout = findViewById(R.id.user_info_table);
//
//        pagerAdapter = new FindPagerAdapter(getSupportFragmentManager(),1);
//        pagerAdapter.AddFragemnt(new UserCjFragment(),"成绩1");
//        pagerAdapter.AddFragemnt(new UserZsFragment(),"证书1");
//    }



}
