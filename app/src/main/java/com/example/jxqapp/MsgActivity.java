package com.example.jxqapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jxqapp.adapter.MsgAdapter;
import com.example.jxqapp.bean.Msg;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends AppCompatActivity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_msg);
        initMsgs();
        msgAdapter = new MsgAdapter(MsgActivity.this,R.layout.activity_msg_item,msgList);
        inputText =(EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = findViewById(R.id.msg_list_view);
        msgListView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                 //   MsgAdapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
        
    }

    private void initMsgs() {
        Msg msg1 = new Msg("hello",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("hello,i fine",Msg.TYPE_RECEIVED);
        msgList.add(msg2);
        Msg msg3 = new Msg("我也很好",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
