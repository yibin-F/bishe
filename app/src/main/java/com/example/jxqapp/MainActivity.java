package com.example.jxqapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.jxqapp.fragment.*;
import com.example.jxqapp.util.StaticUtil;
import com.qmuiteam.qmui.widget.popup.QMUIQuickAction;

import static com.example.jxqapp.util.StaticUtil.student;

public class MainActivity extends FragmentActivity implements View.OnClickListener   {
    /**
     * 底部导航栏的widdget
     */
    private RadioGroup mNavGroup;
    private FragmentTransaction mTransaction;
    private RadioButton ll_chat,ll_dynamic,ll_find,ll_my;
    /**
     * 五个Fragments
     */
    Fragment chatFragemnt, dynamicFragment, findFragment, myFragment;
    public static final int VIEW_CHAT_INDEX = 0;
    public static final int VIEW_DYNAMIC_INDEX = 1;
    public static final int VIEW_FIND_INDEX = 2;
    public static final int VIEW_MY_INDEX = 3;
    private int temp_position_index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
//        if(StaticUtil.userType==1){
//            Toast.makeText(MainActivity.this, student.toString(),Toast.LENGTH_SHORT).show();
//        }
    }

    private void initEvent() {
        ll_chat.setOnClickListener(this);
        ll_dynamic.setOnClickListener(this);
        ll_find.setOnClickListener(this);
        ll_my.setOnClickListener(this);
    }

    private void initView(){
        this.ll_chat = (RadioButton) findViewById(R.id.rb_chat);
        this.ll_dynamic = (RadioButton) findViewById(R.id.rb_dynamic);
        this.ll_find = (RadioButton) findViewById(R.id.rb_find);
        this.ll_my = (RadioButton) findViewById(R.id.rb_my);
        mNavGroup = (RadioGroup)findViewById(R.id.rg_main);
        chatFragemnt = ChatFragment.getChatFragment();
        dynamicFragment = DynamicFragment.getDynamicFragment();
        findFragment = FindFragment.getFindFragment();
        myFragment = MyFragment.getMyFragment();

        //显示
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.fragment,chatFragemnt);
        mTransaction.commit();
    }
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.rb_chat:
                if (temp_position_index != VIEW_CHAT_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.fragment, chatFragemnt);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_CHAT_INDEX;
                break;
            case R.id.rb_dynamic:
                if (temp_position_index != VIEW_DYNAMIC_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.fragment, dynamicFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_DYNAMIC_INDEX;
                break;
            case R.id.rb_find:
                if (temp_position_index != VIEW_FIND_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.fragment, findFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_FIND_INDEX;
                break;
            case R.id.rb_my:
                if (temp_position_index != VIEW_MY_INDEX) {
                    //显示
                    mTransaction = getSupportFragmentManager().beginTransaction();
                    mTransaction.replace(R.id.fragment, myFragment);
                    mTransaction.commit();
                }
                temp_position_index = VIEW_MY_INDEX;
                break;
        }
    }
}
