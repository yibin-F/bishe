package com.example.jxqapp.info_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jxqapp.R;
import com.example.jxqapp.adapter.UserinfoCjAdapter;
import com.example.jxqapp.bean.Chengji;
import com.example.jxqapp.util.HttpUtil;
import com.example.jxqapp.util.StaticUtil;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCjFragment extends Fragment {
    private List<Chengji> chengjiList = new ArrayList<>();
    QMUIGroupListView mGroupListView;
    public UserCjFragment(){}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initCj();
    }

    private void initCj() {
        String ip_url = UserCjFragment.this.getResources().getString(R.string.ip_url);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("u_id",StaticUtil.student_info.getU_id());
        HttpUtil.sendPostRequest("http://" + ip_url + ":8989/findCjlist", map1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),"网络错误",Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = response.body().string();
                            chengjiList = StaticUtil.handleChengjiJsonData(s);
                            System.out.println(chengjiList.toString());
                            UserinfoCjAdapter cjadapter = new UserinfoCjAdapter(getActivity(),R.layout.userinfo_ci_item,chengjiList);
                            ListView listView = (ListView)getActivity().findViewById(R.id.cj_list);
                            listView.setAdapter(cjadapter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user_cj_fragment,container, false);
       // initGroupListView();
        return view;
    }

}
