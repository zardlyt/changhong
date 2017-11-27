package com.changhong.useranalysis.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/23.
 */
public class UserCount {
    private Integer id;
    private Date p_log_date;
    private Long all_user;
    private Long newly_user;
    private Long active_user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getP_log_date() {
        return p_log_date;
    }

    public void setP_log_date(Date p_log_date) {
        this.p_log_date = p_log_date;
    }

    public Long getAll_user() {
        return all_user;
    }

    public void setAll_user(Long all_user) {
        this.all_user = all_user;
    }

    public Long getNewly_user() {
        return newly_user;
    }

    public void setNewly_user(Long newly_user) {
        this.newly_user = newly_user;
    }

    public Long getActive_user() {
        return active_user;
    }

    public void setActive_user(Long active_user) {
        this.active_user = active_user;
    }
}
