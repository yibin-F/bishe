package com.example.jxqapp.bean;

public class ChatItem {
    private String name;
    private String content;
    private String imgstr;
    private String time;
    public ChatItem(String name,String content,String time){
        this.name = name;
        this.content = content;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }

    public String getImgstr() {
        return imgstr;
    }

    public String getTime() {
        return time;
    }
}
