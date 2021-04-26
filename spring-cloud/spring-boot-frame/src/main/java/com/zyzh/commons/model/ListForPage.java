package com.zyzh.commons.model;

import java.util.List;

/**
 * <P>Title: ListForPage</P>
 * <P>Description: 需要分页的表数据模板</P>
 */
public class ListForPage<T>{
    private Integer totalCount;
    private List<T> list;
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    
}
