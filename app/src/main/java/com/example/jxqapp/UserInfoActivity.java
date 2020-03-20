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
import android.widget.TextView;

import com.example.jxqapp.adapter.FindPagerAdapter;
import com.example.jxqapp.bean.Student;
import com.example.jxqapp.info_fragment.UserCjFragment;
import com.example.jxqapp.info_fragment.UserInfoFragment;
import com.example.jxqapp.info_fragment.UserZsFragment;
import com.example.jxqapp.util.StaticUtil;
import com.google.android.material.tabs.TabLayout;

public class UserInfoActivity extends AppCompatActivity{

    private ViewPager userinfoPager;
    private TabLayout tabLayout;
    private TextView user_id,user_phone,user_email,user_class,user_introduct,user_adress,user_name;
    private FindPagerAdapter pagerAdapter = null;
//    Student student = (Student) getIntent().getSerializableExtra("student");
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
            /* 绑定组件 */
            setFindViewId();

    }

    private void setFindViewId() {
        user_name = findViewById(R.id.user_info_name);
        user_name.setText(StaticUtil.student_info.getUser_name());
        user_id = findViewById(R.id.user_info_id);
        user_id.setText(StaticUtil.student_info.getUser_id());
        user_phone = findViewById(R.id.user_info_phone);
        user_phone.setText(StaticUtil.student_info.getUser_phone());
        user_email = findViewById(R.id.user_info_email);
        user_email.setText(StaticUtil.student_info.getUser_email());

        user_class = findViewById(R.id.user_info_banji);
        user_class.setText(StaticUtil.student_info.getGrade_id()+"级"+StaticUtil.student_info.getMajor_name()+StaticUtil.student_info.getClass_id()+"班");
        user_introduct = findViewById(R.id.user_info_introduct);
        user_introduct.setText(StaticUtil.student_info.getIntroduct());
        user_adress = findViewById(R.id.user_info_adress);
        user_adress.setText(StaticUtil.student_info.getAdress());



        userinfoPager = findViewById(R.id.userinfo_pager);
        tabLayout = findViewById(R.id.user_info_table);
        System.out.println(StaticUtil.student_info.toString());
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
