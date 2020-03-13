package com.example.jxqapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class FindPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> fragementListTitle=new ArrayList<>();

    public FindPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragementListTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragementListTitle.get(position);
    }

    public void AddFragemnt(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragementListTitle.add(title);
    }
}
