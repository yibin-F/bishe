package com.example.jxqapp.bean;

public class FriendDynamic {
    private int imageId;
    private String userName;
    private String dynamicContent;
    private String dynamicTime;
    public FriendDynamic(String userName,String dynamicContent,int imageId,String dynamicTime) {
        this.userName = userName;
        this.dynamicContent = dynamicContent;
        this.imageId = imageId;
        this.dynamicTime = dynamicTime;
    }
    public int getImageId() {
        return imageId;
    }
    public String getUserName(){return  userName;}
    public String getDynamicContent(){return dynamicContent;}

    public String getDynamicTime() {
        return dynamicTime;
    }
}
