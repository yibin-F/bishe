package com.example.jxqapp.info_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jxqapp.R;
import com.example.jxqapp.adapter.FindPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class UserInfoFragment extends Fragment {
    private ViewPager userinfoPager;
    private TabLayout tabLayout;
    private FindPagerAdapter pagerAdapter = null;
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userinfoPager = this.getActivity().findViewById(R.id.userinfo_pager);
        tabLayout = this.getActivity().findViewById(R.id.user_info_table);

        pagerAdapter = new FindPagerAdapter(getChildFragmentManager(),1);
        pagerAdapter.AddFragemnt(new UserCjFragment(),"成绩1");
        pagerAdapter.AddFragemnt(new UserZsFragment(),"证书1");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user_info_fragment,container, false);
        return view;
    }
}
