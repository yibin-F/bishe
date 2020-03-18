package com.example.jxqapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jxqapp.bean.Student;
import com.example.jxqapp.util.StaticUtil;

public class EditInfoActivity extends AppCompatActivity {
    private LinearLayout edit_touxiang,edit_id,edit_name,edit_sex,edit_phone,edit_class,edit_adress,edit_email,edit_introduct;
    private TextView text_id,text_name,text_phone,text_class,text_adress,text_email,text_introduct,text_sex;
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
