package com.example.jxqapp.AlterInfo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jxqapp.LoginActivity;
import com.example.jxqapp.R;
import com.example.jxqapp.util.HttpUtil;
import com.example.jxqapp.util.StaticUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Alter_PasswordActivity extends AppCompatActivity {
    private EditText intput_alter1;
    private EditText intput_alter2;
    private TextView error;
    String password1;
    String password2;
    int u_id;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_password);
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

    private void setFindViewId() {
        intput_alter1 = findViewById(R.id.input_password);
        intput_alter2 = findViewById(R.id.input_rePassword);
        submit = findViewById(R.id.btn_submit);
        error = findViewById(R.id.error_input);
    }

    private void setListeners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password1 = intput_alter1.getText().toString();
                password2 = intput_alter2.getText().toString();
                String ip_url = Alter_PasswordActivity.this.getResources().getString(R.string.ip_url);
                //学生
                if(StaticUtil.userType==1&&password2.equals(password1)){
                    u_id= StaticUtil.student.getU_id();
                    Map<String,Object> map1 = new HashMap<>();
                    map1.put("password",password1);
                    map1.put("uid",u_id);
                    HttpUtil.sendPostRequest("http://" + ip_url + ":8989/alter_password1", map1, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"修改成功，请重新登录",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Alter_PasswordActivity.this,LoginActivity.class);
                                    //清空所有活动，回到登录界面
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                    });
                }
                //教师
                else if(StaticUtil.userType==2&&password2.equals(password1)){
                    u_id= StaticUtil.teacher.getU_id();
                    Map<String,Object> map1 = new HashMap<>();
                    map1.put("password",password1);
                    map1.put("uid",u_id);
                    HttpUtil.sendPostRequest("http://" + ip_url + ":8989/alter_password2", map1, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"修改成功，请重新登录",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Alter_PasswordActivity.this,LoginActivity.class);
                                    //清空所有活动，回到登录界面
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                    });
                }
                //家长
                else if(StaticUtil.userType==3&&password2.equals(password1)){
                    u_id= StaticUtil.parent.getU_id();
                    Map<String,Object> map1 = new HashMap<>();
                    map1.put("password",password1);
                    map1.put("uid",u_id);
                    HttpUtil.sendPostRequest("http://" + ip_url + ":8989/alter_password3", map1, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"修改成功，请重新登录",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Alter_PasswordActivity.this,LoginActivity.class);
                                    //清空所有活动，回到登录界面
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                    });
                }
                //企业
                else if(StaticUtil.userType==4&&password2.equals(password1)){
                    u_id= StaticUtil.company.getU_id();
                    Map<String,Object> map1 = new HashMap<>();
                    map1.put("password",password1);
                    map1.put("uid",u_id);
                    HttpUtil.sendPostRequest("http://" + ip_url + ":8989/alter_password4", map1, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Alter_PasswordActivity.this,"修改成功，请重新登录",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Alter_PasswordActivity.this,LoginActivity.class);
                                    //清空所有活动，回到登录界面
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                    });
                }
//                else if(password1==""){
//                    error.setVisibility(View.VISIBLE);
//                    Toast.makeText(Alter_PasswordActivity.this,"密码为空",Toast.LENGTH_SHORT).show();
//                }
                else{
                    error.setVisibility(View.VISIBLE);
                    Toast.makeText(Alter_PasswordActivity.this,"密码不一致",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
