package com.changhong.dataanalysis.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/22.
 */
public class DataCount {
    private Integer id;
    private Date p_log_date;
    private Long all_domain;
    private Long video;
    private Long app;
    private Long tv;
    private Long baike;
    private Long talk;
    private Long music;

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

    public Long getAll_domain() {
        return all_domain;
    }

    public void setAll_domain(Long all_domain) {
        this.all_domain = all_domain;
    }

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
    }

    public Long getTv() {
        return tv;
    }

    public void setTv(Long tv) {
        this.tv = tv;
    }

    public Long getBaike() {
        return baike;
    }

    public void setBaike(Long baike) {
        this.baike = baike;
    }

    public Long getTalk() {
        return talk;
    }

    public void setTalk(Long talk) {
        this.talk = talk;
    }

    public Long getMusic() {
        return music;
    }

    public void setMusic(Long music) {
        this.music = music;
    }

    public Long getVideo() {
        return video;
    }

    public void setVideo(Long video) {
        this.video = video;
    }
}
