package com.example.jxqapp;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jxqapp.util.HttpUtil;

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

public class LoginActivity extends AppCompatActivity {
    private Button btn_submit;
    private EditText intput_username;
    private EditText intput_password;
    boolean isSubmit = true;
    String username;
    String password;

    final OkHttpClient client = new OkHttpClient();
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                String ReturnMessage = (String)msg.obj;
                Log.i("获取的返回信息",ReturnMessage);
                /***
                 * 在此处可以通过获取到的Msg值来判断
                 * 给出用户提示注册成功 与否，以及判断是否用户名已经存在
                 */
                isSubmit = true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
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
    }

//    监听器
    private void setListeners() {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = intput_username.getText().toString().trim();
                password = intput_password.getText().toString().trim();
                Map<String, Object> map1 = new HashMap<>();
                map1.put("username",username);
                map1.put("password",password);
                //防止多次提交登录请求
                if(isSubmit){
                   // isSubmit = false;
                    //通过okhttp发起post请求
                    HttpUtil.sendPostRequest("http://192.168.0.6:8989/login", map1, new Callback() {
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
                                        if(response.body().string().equals("1"))
                                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    });
                 //   postRequest(username,password);
                }
            }
        });
    }

    private void postRequest(String username, String password) {
        //建立请求表单，添加上传服务器的参数
        RequestBody formBody = new FormBody.Builder()
                .add("username",username)
                .add("password",password)
                .build();
        //发起请求
        final Request request = new Request.Builder()
                .url("http://192.168.0.6:8989/login")
                .post(formBody)
                .build();
        Toast.makeText(LoginActivity.this,"fsdf",Toast.LENGTH_SHORT).show();
        //新建一个线程，用于得到服务器响应的参数
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    //回调
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()){
                    //将服务器响应的参数response.body().string())发送到hanlder中，并更新ui
                        Log.d("",response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
