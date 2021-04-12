package org.zxy.entity;

/**
 * @Description User
 * @Created by Administrator on 2021/4/12 14:04
 */
public class User {

    private Integer id;
    private String userName;
    private String passWord;
    private String realName;
    private int tstring;
    private int tint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getTstring() {
        return tstring;
    }

    public void setTstring(int tstring) {
        this.tstring = tstring;
    }

    public int getTint() {
        return tint;
    }

    public void setTint(int tint) {
        this.tint = tint;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", tstring='" + tstring + '\'' +
                ", tint='" + tint + '\'' +
                '}';
    }
}
