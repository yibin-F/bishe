package com.example.jxqapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.Util;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jxqapp.adapter.FindAdapter;
import com.example.jxqapp.bean.ChatItem;
import com.example.jxqapp.bean.FindItem;
import com.example.jxqapp.bean.Student;
import com.example.jxqapp.fragment.ChatFragment;
import com.example.jxqapp.fragment.FindFragment;
import com.example.jxqapp.util.HttpUtil;
import com.example.jxqapp.util.StaticUtil;
import com.google.gson.Gson;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find1Activity extends Fragment implements AdapterView.OnItemClickListener {
    private List<FindItem> findList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private static Find1Activity mf;
    //单例模式
    public static Find1Activity getFind1Activity()
    {
        if(mf == null){
            mf = new Find1Activity();
        }
        return mf;
    }
   public Find1Activity(){}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_find1,container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork()
//                .penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
//                .penaltyLog().penaltyDeath().build());

        initFind();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Map<String,Object> map1 = new HashMap<>();
//                map1.put("class_id",StaticUtil.student.getClass_id());
//                map1.put("grade_id",StaticUtil.student.getGrade_id());
//                map1.put("major_id",StaticUtil.student.getMajor_id());
//                String ip_url = Find1Activity.this.getResources().getString(R.string.ip_url);
//                HttpUtil.sendPostRequest("http://" + ip_url + ":8989/findStudentlist", map1, new Callback(){
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String s = response.body().string();
//                        studentList = StaticUtil.handleStudentJsonData(s);
//                        FindAdapter findadapter = new FindAdapter(getActivity(),R.layout.find_item,studentList);
//                        ListView listView = (ListView)getActivity().findViewById(R.id.banji_list);
//                        listView.setOnItemClickListener(Find1Activity.this);
//                        listView.setAdapter(findadapter);
//                    }
//                });
//            }
//        }).start();
//        FindAdapter findadapter = new FindAdapter(this.getActivity(),R.layout.find_item,studentList);
//       ListView listView = (ListView)this.getActivity().findViewById(R.id.banji_list);
//       listView.setOnItemClickListener(this);
//        listView.setAdapter(findadapter);
    }

    private void initFind() {
        //当前用户为学生
        if (StaticUtil.userType==1){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("class_id",StaticUtil.student.getClass_id());
            map1.put("grade_id",StaticUtil.student.getGrade_id());
            map1.put("major_id",StaticUtil.student.getMajor_id());
            String ip_url = Find1Activity.this.getResources().getString(R.string.ip_url);
            HttpUtil.sendPostRequest("http://" + ip_url + ":8989/findStudentlist", map1, new Callback() {
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
                            studentList = StaticUtil.handleStudentJsonData(s);
                                FindAdapter findadapter = new FindAdapter(getActivity(),R.layout.find_item,studentList);
                                ListView listView = (ListView)getActivity().findViewById(R.id.banji_list);
                                listView.setOnItemClickListener(Find1Activity.this);
                                listView.setAdapter(findadapter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        }
                    });

                }
            });
        }
//
//        findList.clear();
//        FindItem a1 = new FindItem("小刚");
//        findList.add(a1);
//        FindItem a2 = new FindItem("小红");
//        findList.add(a2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //  Student student = studentList.get(position);
        StaticUtil.student_info = studentList.get(position);
        Intent intent = new Intent(this.getActivity(), UserInfoActivity.class);
        startActivity(intent);
    }
}
