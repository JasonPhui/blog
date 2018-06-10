package cn.ph.blog.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfo {

    /**
     *主键
     */
    private int id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
