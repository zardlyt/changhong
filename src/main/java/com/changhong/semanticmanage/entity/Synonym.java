package com.changhong.semanticmanage.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Synonym {
    private Integer id;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String entity_name;
    private String similar_words;
    private Boolean status_flag;
    private String user;
    private Timestamp created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
    }

    public String getEntity_name() {
        return entity_name;
    }

    public void setEntity_name(String entity_name) {
        this.entity_name = entity_name;
    }

    public String getSimilar_words() {
        return similar_words;
    }

    public void setSimilar_words(String similar_words) {
        this.similar_words = similar_words;
    }

    public Boolean getStatus_flag() {
        return status_flag;
    }

    public void setStatus_flag(Boolean status_flag) {
        this.status_flag = status_flag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
