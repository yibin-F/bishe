package com.example.jxqapp.shenghe;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jxqapp.MsgActivity;
import com.example.jxqapp.R;

public class ShengheContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shenghe_content);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
