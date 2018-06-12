package cn.ph.blog.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class UserInfo {

    /**
     *主键
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     * 使用@Transient注解表示忽略字段，不作为表字段使用
     */
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
