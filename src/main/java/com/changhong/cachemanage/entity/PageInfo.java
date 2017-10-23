package com.changhong.cachemanage.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 */
public class PageInfo {
    private int page; //当前页数
    private int totalCount;  //总记录数
    private int totalPage;  //总页数
    private int limit;   //每页显示的记录数
    private List<Map> list; //每页显示数据记录的集合；

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }
}
