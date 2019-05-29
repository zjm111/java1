package com.zjm.usual.bean;

import com.zjm.emp.bean.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {
    private Integer id;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date starttime;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date endtime;

    private String level;

    private String define;

    private Integer funFk;

    private Integer empFk2;

    private Integer empFk;

    private Employee emp;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define == null ? null : define.trim();
    }

    public Integer getFunFk() {
        return funFk;
    }

    public void setFunFk(Integer funFk) {
        this.funFk = funFk;
    }

    public Integer getEmpFk2() {
        return empFk2;
    }

    public void setEmpFk2(Integer empFk2) {
        this.empFk2 = empFk2;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
}