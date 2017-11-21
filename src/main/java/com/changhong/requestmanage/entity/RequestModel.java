package com.changhong.requestmanage.entity;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/11/17.
 */
public class RequestModel {
    private Integer id;
    private String query_text;
    private String return_semantic;
    private Timestamp time;
    private String query_mac;
    private Integer collect;
    private Timestamp collect_time;


    private Integer pageNo = 1;
    private Integer begin;
    private Integer limit;

    private Integer counts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuery_text() {
        return query_text;
    }

    public void setQuery_text(String query_text) {
        this.query_text = query_text;
    }

    public String getReturn_semantic() {
        return return_semantic;
    }

    public void setReturn_semantic(String return_semantic) {
        this.return_semantic = return_semantic;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getQuery_mac() {
        return query_mac;
    }

    public void setQuery_mac(String query_mac) {
        this.query_mac = query_mac;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Timestamp getCollect_time() {
        return collect_time;
    }

    public void setCollect_time(Timestamp collect_time) {
        this.collect_time = collect_time;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
