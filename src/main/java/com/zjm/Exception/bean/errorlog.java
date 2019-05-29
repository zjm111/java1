package com.zjm.Exception.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: PMS
 * @description: 处理异常
 * @author: Mr.
 * @create: 2019-04-17 23:26
 **/
public class errorlog {
    private int id;
    private String cause;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @Override
    public String toString() {
        return "errorlog{" +
                "id=" + id +
                ", cause='" + cause + '\'' +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
