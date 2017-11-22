package com.changhong.dataanalysis.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/22.
 */
public class DataCount {
    private Integer id;
    private Date p_log_date;
    private Integer all_domain;
    private Integer video;
    private Integer app;
    private Integer tv;
    private Integer baike;
    private Integer talk;
    private Integer music;

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

    public Integer getAll_domain() {
        return all_domain;
    }

    public void setAll_domain(Integer all_domain) {
        this.all_domain = all_domain;
    }

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }

    public Integer getTv() {
        return tv;
    }

    public void setTv(Integer tv) {
        this.tv = tv;
    }

    public Integer getBaike() {
        return baike;
    }

    public void setBaike(Integer baike) {
        this.baike = baike;
    }

    public Integer getTalk() {
        return talk;
    }

    public void setTalk(Integer talk) {
        this.talk = talk;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getVideo() {
        return video;
    }

    public void setVideo(Integer video) {
        this.video = video;
    }
}
