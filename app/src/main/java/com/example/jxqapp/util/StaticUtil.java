package com.example.jxqapp.util;

import com.example.jxqapp.bean.Chengji;
import com.example.jxqapp.bean.Company;
import com.example.jxqapp.bean.Parent;
import com.example.jxqapp.bean.Student;
import com.example.jxqapp.bean.Teacher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class StaticUtil {
    public static Student student,student_info;
    public static Teacher teacher;
    public static Parent parent;
    public static Company company;
    public static int userType;
    public static String username;
    public static List<Student> handleStudentJsonData(String jsonData){
        List<Student> list= null;
        Gson gson = new Gson();
        if (jsonData!=null){
            try {
                list = gson.fromJson(jsonData,new TypeToken<ArrayList<Student>>(){}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    public static List<Chengji> handleChengjiJsonData(String jsonData){
        List<Chengji> list= null;
        Gson gson = new Gson();
        if (jsonData!=null){
            try {
                list = gson.fromJson(jsonData,new TypeToken<ArrayList<Chengji>>(){}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
