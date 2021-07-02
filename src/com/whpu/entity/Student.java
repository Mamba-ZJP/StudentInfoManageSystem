package com.whpu.entity;

public class Student {
    private Integer sid;
    private String sname;
    private String sno;
    private Integer gradeid;
    private String address;
    private Integer score;
    private String password;

    public Student(Integer sid, String sname, String sno, Integer gradeid, String address, Integer score, String password) {
        this.sid = sid;
        this.sname = sname;
        this.sno = sno;
        this.gradeid = gradeid;
        this.address = address;
        this.score = score;
        this.password = password;
    }

    public Student(String sname, String sno, Integer gradeid, String address, Integer score, String password) {
        this.sname = sname;
        this.sno = sno;
        this.gradeid = gradeid;
        this.address = address;
        this.score = score;
        this.password = password;
    }

    public Student() {}

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sno='" + sno + '\'' +
                ", gradeid=" + gradeid +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }
}
