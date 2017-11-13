package com.changhong.dataconversion.entity;

/**
 * Created by Administrator on 2017/11/9.
 */
public class DataConvert {
    private Integer id;
    private String type;
    private String semantic;
    private String paltform;

    private Integer pageNo = 1;
    private Integer begin;
    private Integer limit;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSemantic() {
        return semantic;
    }

    public void setSemantic(String semantic) {
        this.semantic = semantic;
    }

    public String getPaltform() {
        return paltform;
    }

    public void setPaltform(String paltform) {
        this.paltform = paltform;
    }
}
