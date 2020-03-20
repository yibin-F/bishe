package com.example.jxqapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jxqapp.bean.Student;
import com.example.jxqapp.util.HttpUtil;
import com.example.jxqapp.util.StaticUtil;
import com.google.gson.Gson;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EditInfoActivity extends AppCompatActivity {
    private LinearLayout edit_touxiang,edit_id,edit_name,edit_sex,edit_phone,edit_class,edit_adress,edit_email,edit_introduct;
    private TextView text_id,text_name,text_phone,text_class,text_adress,text_email,text_introduct,text_sex;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        /* 绑定组件 */
        setFindViewId();
        /* 添加监听器 */
        setListeners();
    }

    private void setListeners() {
        edit_introduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditTextDialog();
            }
        });
    }

    private void showEditTextDialog() {
        final QMUIDialog.EditTextDialogBuilder builder = new QMUIDialog.EditTextDialogBuilder(EditInfoActivity.this);
        builder.setPlaceholder("在此输入您的昵称")
                .setInputType(InputType.TYPE_CLASS_TEXT)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(final QMUIDialog dialog, int index) {
                        final CharSequence text = builder.getEditText().getText();
                        String ip_url = EditInfoActivity.this.getResources().getString(R.string.ip_url);
                        final Map<String,Object> map1 = new HashMap<>();
                        map1.put("text",text);
                        map1.put("uid",StaticUtil.student.getU_id());
                        HttpUtil.sendPostRequest("http://"+ip_url+":8989/alter_introduct", map1, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                            }

                            @Override
                            public void onResponse(Call call, final Response response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            StaticUtil.student.setIntroduct(text.toString());
                                            dialog.dismiss();
                                            final QMUITipDialog tipDialog;
                                            tipDialog = new QMUITipDialog.Builder(EditInfoActivity.this)
                                                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                                                    .setTipWord("修改成功")
                                                    .create();
                                            tipDialog.show();
                                            text_introduct.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    tipDialog.dismiss();
                                                }
                                            },1500);
                                            setFindViewId();

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }
                        });
                    }
                })
                .create(mCurrentDialogStyle).show();
    }


    private void setFindViewId() {
        //整行组件
        edit_adress = findViewById(R.id.edit_adress);
        edit_class = findViewById(R.id.edit_class);
        edit_email = findViewById(R.id.edit_email);
        edit_id = findViewById(R.id.edit_id);
        edit_introduct = findViewById(R.id.edit_introduct);
        edit_name = findViewById(R.id.edit_name);
        edit_phone = findViewById(R.id.edit_phone);
        edit_touxiang = findViewById(R.id.edit_touxiang);
        //edit_touxiang.setVisibility(edit_touxiang.GONE);

        //具体文本信息组件
        text_id = findViewById(R.id.editinfo_id);
        text_name = findViewById(R.id.editinfo_name);
        text_sex = findViewById(R.id.editinfo_sex);
        text_adress = findViewById(R.id.editinfo_adress);
        text_class = findViewById(R.id.editinfo_class);
        text_email = findViewById(R.id.editinfo_email);
        text_introduct = findViewById(R.id.editinfo_introduct);
        text_phone = findViewById(R.id.editinfo_phone);
        //用户为学生
        if(StaticUtil.userType==1){
            text_id.setText(StaticUtil.student.getUser_id());
            text_name.setText(StaticUtil.student.getUser_name());
            if (StaticUtil.student.getUser_sex().equals("0")){
                text_sex.setText("男");
            }else if (StaticUtil.student.getUser_sex().equals("1")){
                text_sex.setText("女");
            }else{
                text_sex.setText("");
            }
            text_phone.setText(StaticUtil.student.getUser_phone());
            text_introduct.setText(StaticUtil.student.getIntroduct());
            text_email.setText(StaticUtil.student.getUser_email());
            text_class.setText(StaticUtil.student.getGrade_id()+""+StaticUtil.student.getMajor_name()+StaticUtil.student.getClass_id()+"班");
            text_adress.setText(StaticUtil.student.getAdress());
        }
        //用户为老师
        if(StaticUtil.userType==2){
            //隐藏布局
            edit_introduct.setVisibility(edit_introduct.GONE);
            edit_class.setVisibility(edit_class.GONE);

            text_id.setText(StaticUtil.teacher.getUser_id());
            text_name.setText(StaticUtil.teacher.getUser_name());
            if (StaticUtil.teacher.getUser_sex().equals("0")){
                text_sex.setText("男");
            }else if (StaticUtil.teacher.getUser_sex().equals("1")){
                text_sex.setText("女");
            }else{
                text_sex.setText("");
            }
            text_phone.setText(StaticUtil.teacher.getUser_phone());
            text_email.setText(StaticUtil.teacher.getUser_email());
            text_adress.setText(StaticUtil.teacher.getAdress());
        }

        //用户为家长
        if(StaticUtil.userType==3){
            edit_introduct.setVisibility(edit_introduct.GONE);
            edit_class.setVisibility(edit_class.GONE);

            text_id.setText(StaticUtil.parent.getUser_id());
            text_name.setText(StaticUtil.parent.getUser_name());
            if (StaticUtil.parent.getUser_sex().equals("0")){
                text_sex.setText("男");
            }else if (StaticUtil.parent.getUser_sex().equals("1")){
                text_sex.setText("女");
            }else{
                text_sex.setText("");
            }
            text_phone.setText(StaticUtil.parent.getUser_phone());
            text_email.setText(StaticUtil.parent.getUser_email());
            text_adress.setText(StaticUtil.parent.getAdress());
        }
        //用户为企业
        if(StaticUtil.userType==4){
            edit_introduct.setVisibility(edit_introduct.GONE);
            edit_class.setVisibility(edit_class.GONE);
            edit_sex.setVisibility(edit_sex.GONE);

            text_id.setText(StaticUtil.company.getUser_id());
            text_name.setText(StaticUtil.company.getUser_name());
            text_phone.setText(StaticUtil.company.getUser_phone());
            text_email.setText(StaticUtil.company.getUser_email());
            text_adress.setText(StaticUtil.company.getAddress());
        }
    }
}
