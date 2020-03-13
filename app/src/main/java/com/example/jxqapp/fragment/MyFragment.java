package com.example.jxqapp.fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jxqapp.EditInfoActivity;
import com.example.jxqapp.R;
import com.example.jxqapp.myfragment.ShengheActivity;

public class MyFragment extends Fragment implements View.OnClickListener {
    private TextView editInfo;
    private LinearLayout shenhe;
    private static MyFragment mf;

    //单例模式
    public static MyFragment getMyFragment() {
        if (mf == null) {
            mf = new MyFragment();
        }
        return mf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editInfo = (TextView) this.getActivity().findViewById(R.id.my_bianji);
        editInfo.setOnClickListener(this);

        shenhe = this.getActivity().findViewById(R.id.my_shenhe);
        shenhe.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_bianji:
                Intent intent = new Intent(this.getActivity(), EditInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.my_shenhe:
                Intent intent1 = new Intent(this.getActivity(), ShengheActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
