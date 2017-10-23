package com.changhong.semanticmanage.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/18.
 */
public class Semantic {
    private Integer id;
    private String sentence;
    private String squery;
    private String spellCheck;
    private Boolean madeChange;
    private Integer stateCode;
    private String stype;
    private Integer state;
    private String method;
    private String stime;


    private Integer pageNo = 1;
    private Integer begin;
    private Integer limit;

    public Integer getPageNo() {
        return pageNo;
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

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSquery() {
        return squery;
    }

    public void setSquery(String squery) {
        this.squery = squery;
    }

    public String getSpellCheck() {
        return spellCheck;
    }

    public void setSpellCheck(String spellCheck) {
        this.spellCheck = spellCheck;
    }

    public Boolean getMadeChange() {
        return madeChange;
    }

    public void setMadeChange(Boolean madeChange) {
        this.madeChange = madeChange;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }
}
