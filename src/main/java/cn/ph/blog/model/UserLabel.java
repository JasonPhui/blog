package cn.ph.blog.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_label")
public class UserLabel {
    @Id
    private String id;

    @Column(name = "labelId")
    private String labelid;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return labelId
     */
    public String getLabelid() {
        return labelid;
    }

    /**
     * @param labelid
     */
    public void setLabelid(String labelid) {
        this.labelid = labelid == null ? null : labelid.trim();
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}