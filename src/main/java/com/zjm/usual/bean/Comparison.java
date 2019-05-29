package com.zjm.usual.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comparison {
    private Integer cid;

    private String company;//公司

    private Double targetmoney;//营业额

    private String year;//年份

    private String busines;//主要业务

    private String priority;//优势

    private String bad;//劣势

    private String status;//行业地位

    private int empCount;//员工数量
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;//创建时间

    private String description;//简述

    private Integer empFk;//外键

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getTargetmoney() {
        return targetmoney;
    }

    public void setTargetmoney(Double targetmoney) {
        this.targetmoney = targetmoney;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBusines() {
        return busines;
    }

    public void setBusines(String busines) {
        this.busines = busines;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmpCount() {
        return empCount;
    }

    public void setEmpCount(int empCount) {
        this.empCount = empCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    @Override
    public String toString() {
        return "Comparison{" +
                "cid=" + cid +
                ", company='" + company + '\'' +
                ", targetmoney=" + targetmoney +
                ", year='" + year + '\'' +
                ", busines='" + busines + '\'' +
                ", priority='" + priority + '\'' +
                ", bad='" + bad + '\'' +
                ", status='" + status + '\'' +
                ", empCount=" + empCount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", empFk=" + empFk +
                '}';
    }
}