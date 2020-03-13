package com.example.jxqapp.fragment;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jxqapp.ChatAdapter;
import com.example.jxqapp.MsgActivity;
import com.example.jxqapp.bean.ChatItem;
import com.example.jxqapp.LoginActivity;
import com.example.jxqapp.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<ChatItem> chatList = new ArrayList<>();
    private static ChatFragment mf;
    //单例模式
    public static ChatFragment getChatFragment()
    {
        if(mf == null){
            mf = new ChatFragment();
        }
        return mf;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initChat();
        ChatAdapter adapter = new ChatAdapter(this.getActivity(),R.layout.chat_item,chatList);
        ListView listView = (ListView)this.getActivity().findViewById(R.id.list_chat);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chat_fragment ,container, false);
        return view;
    }

    private void initChat() {
        chatList.clear();
        ChatItem a1 = new ChatItem("小刚","你吃了么啊","4:10");
        chatList.add(a1);
        ChatItem a2 = new ChatItem("小红","嗯嗯","4:00");
        chatList.add(a2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ChatItem chatItem = chatList.get(position);
        Toast.makeText(this.getActivity(),"545dfs",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this.getActivity(), MsgActivity.class);
        startActivity(intent);
    }
}
