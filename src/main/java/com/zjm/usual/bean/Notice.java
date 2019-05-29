package com.zjm.usual.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Notice {
    private Integer nid;

    private String ntitle;

    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ndate;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle == null ? null : ntitle.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }
}