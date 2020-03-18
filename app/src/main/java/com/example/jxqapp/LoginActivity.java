package com.example.jxqapp;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jxqapp.bean.Company;
import com.example.jxqapp.bean.Parent;
import com.example.jxqapp.bean.Student;
import com.example.jxqapp.bean.Teacher;
import com.example.jxqapp.util.HttpUtil;
import com.example.jxqapp.util.StaticUtil;
import com.google.gson.Gson;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.jxqapp.util.StaticUtil.student;

public class LoginActivity extends AppCompatActivity {
    private Button btn_submit;
    private EditText intput_username;
    private EditText intput_password;
    private AVLoadingIndicatorView loadingView;
    private RadioGroup login_radioGroup;//身份类别选择
    boolean isSubmit = true;
    int userKind = 1;
    String username;
    String password;

    final OkHttpClient client = new OkHttpClient();
//    private Handler mHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            if(msg.what==1){
//                String ReturnMessage = (String)msg.obj;
//                Log.i("获取的返回信息",ReturnMessage);
//                /***
//                 * 在此处可以通过获取到的Msg值来判断
//                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
//                 */
//                isSubmit = true;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads().detectDiskWrites().detectNetwork()
//                .penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
//                .penaltyLog().penaltyDeath().build());
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        /* 绑定组件 */
        setFindViewId();
        /* 添加监听器 */
        setListeners();

    }
    /* 绑定组件 */
    private void setFindViewId() {
        intput_username = findViewById(R.id.input_username);
        intput_password = findViewById(R.id.input_password);
        btn_submit = findViewById(R.id.btn_submit);
        login_radioGroup = findViewById(R.id.login_radioGroup);
//        loadingView = findViewById(R.id.loadView);
    }

//    监听器
    private void setListeners() {
        //身份类型
        login_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton =findViewById(checkedId);
                String s = radioButton.getText().toString();
                if(s.equals("学生")){ userKind = 1; }
                else if(s.equals("教师")){ userKind = 2; }
                else if(s.equals("家长")){ userKind = 3; }
                else if(s.equals("企业")){ userKind = 4; }
            }
        });

        //登录
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = intput_username.getText().toString();
                password = intput_password.getText().toString();
                Map<String, Object> map1 = new HashMap<>();
                map1.put("username",username);
                map1.put("password",password);
                //防止多次提交登录请求
                if(isSubmit){
                    isSubmit = true;
//                    loadingView.startAnimation();
                    //通过okhttp发起post请求
                    String ip_url = LoginActivity.this.getResources().getString(R.string.ip_url);
                    if (userKind==1){
                        HttpUtil.sendPostRequest("http://"+ip_url+":8989/studentlogin", map1, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String s = response.body().string();
                                            Student student = new Gson().fromJson(s,Student.class);
                                            if(student!=null){
                                                Toast.makeText(LoginActivity.this,"欢迎，"+student.getUser_name(),Toast.LENGTH_SHORT).show();
                                                StaticUtil.userType = userKind;
                                                StaticUtil.student = student;
                                                StaticUtil.username = student.getUser_name();
                                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }else {
                                                Toast.makeText(LoginActivity.this, "账户不存在",Toast.LENGTH_SHORT).show();
                                            }
//                                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                                            startActivity(intent);
                     //                       finish();

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    if (userKind==2){
                        HttpUtil.sendPostRequest("http://"+ip_url+":8989/teacherlogin", map1, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this,"失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String s = response.body().string();
                                            Teacher teacher = new Gson().fromJson(s,Teacher.class);
                                            if(teacher!=null){
                                                Toast.makeText(LoginActivity.this,"欢迎，"+teacher.getUser_name(),Toast.LENGTH_SHORT).show();
                                                StaticUtil.userType = userKind;
                                                StaticUtil.teacher = teacher;
                                                StaticUtil.username = teacher.getUser_name();
                                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }else {
                                                Toast.makeText(LoginActivity.this, "账户不存在",Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    if (userKind==3){
                        HttpUtil.sendPostRequest("http://"+ip_url+":8989/parentlogin", map1, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this,"失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String s = response.body().string();
                                            Parent parent = new Gson().fromJson(s,Parent.class);
                                            if(parent!=null){
                                                Toast.makeText(LoginActivity.this,"欢迎，"+parent.getUser_name(),Toast.LENGTH_SHORT).show();
                                                StaticUtil.userType = userKind;
                                                StaticUtil.parent = parent;
                                                StaticUtil.username = parent.getUser_name();
                                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }else {
                                                Toast.makeText(LoginActivity.this, "账户不存在",Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    if (userKind==4){
                        HttpUtil.sendPostRequest("http://"+ip_url+":8989/companylogin", map1, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this,"失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String s = response.body().string();
                                            Company company = new Gson().fromJson(s,Company.class);
                                            if(company!=null){
                                                Toast.makeText(LoginActivity.this,"欢迎，"+company.getUser_name(),Toast.LENGTH_SHORT).show();
                                                StaticUtil.userType = userKind;
                                                StaticUtil.company = company;
                                                StaticUtil.username = company.getUser_name();
                                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }else {
                                                Toast.makeText(LoginActivity.this, "账户不存在",Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });

                    }

                }
            }
        });
    }

//    private void postRequest(String username, String password) {
//        //建立请求表单，添加上传服务器的参数
//        RequestBody formBody = new FormBody.Builder()
//                .add("username",username)
//                .add("password",password)
//                .build();
//        //发起请求
//        final Request request = new Request.Builder()
//                .url("http://192.168.0.6:8989/login")
//                .post(formBody)
//                .build();
//        Toast.makeText(LoginActivity.this,"fsdf",Toast.LENGTH_SHORT).show();
//        //新建一个线程，用于得到服务器响应的参数
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Response response = null;
//                try {
//                    //回调
//                    response = client.newCall(request).execute();
//                    if (response.isSuccessful()){
//                    //将服务器响应的参数response.body().string())发送到hanlder中，并更新ui
//                        Log.d("",response.body().string());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
}
