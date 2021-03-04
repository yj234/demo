package com.review.demo.model;

import java.util.Date;

public class Dept {
    private int id;
    private String deptName;
    private int dataStatu;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDataStatu() {
        return dataStatu;
    }

    public void setDataStatu(int dataStatu) {
        this.dataStatu = dataStatu;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
