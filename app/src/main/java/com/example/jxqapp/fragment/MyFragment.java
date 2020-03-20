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

import com.example.jxqapp.AlterInfo.Alter_PasswordActivity;
import com.example.jxqapp.EditInfoActivity;
import com.example.jxqapp.R;
import com.example.jxqapp.myfragment.ShengheActivity;
import com.example.jxqapp.util.StaticUtil;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

public class MyFragment extends Fragment implements View.OnClickListener {
    private TextView editInfo;
    private LinearLayout shenhe,xiugai_ll;
    private static MyFragment mf;
    private QMUIRadiusImageView2 user_img;

    //单例模式
    public static MyFragment getMyFragment() {
        if (mf == null) {
            mf = new MyFragment();
        }
        return mf;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        user_img = this.getActivity().findViewById(R.id.user_image);
        user_img.setCircle(true);

        editInfo = (TextView) this.getActivity().findViewById(R.id.my_bianji);
        editInfo.setOnClickListener(this);

        xiugai_ll = this.getActivity().findViewById(R.id.my_xiugai);
        xiugai_ll.setOnClickListener(this);

        shenhe = this.getActivity().findViewById(R.id.my_shenhe);
        shenhe.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment, container, false);
        TextView textView = view.findViewById(R.id.my_name);
        textView.setText(StaticUtil.username);

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
            case R.id.my_xiugai:
                Intent intent2 = new Intent(this.getActivity(), Alter_PasswordActivity.class);
                startActivity(intent2);
        }
    }
}
