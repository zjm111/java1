package com.zjm.usual.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: PMS
 * @description: 帖子
 * @author: Mr.
 * @create: 2019-04-15 19:00
 **/
public class TieZi {
    private Integer tid;
    private String  biaoti;//标题
    private String  neirong;//内容
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;//时间

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    @Override
    public String toString() {
        return "TieZi{" +
                "tid=" + tid +
                ", biaoti='" + biaoti + '\'' +
                ", neirong='" + neirong + '\'' +
                ", date=" + date +
                '}';
    }
}
