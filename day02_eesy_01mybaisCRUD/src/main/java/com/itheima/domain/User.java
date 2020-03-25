package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private char userSex;
    private String userAddress;





    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex=" + userSex +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }



    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public void setUserSex(char userSex) {
        this.userSex = userSex;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }



    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public char getUserSex() {
        return userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }
}
