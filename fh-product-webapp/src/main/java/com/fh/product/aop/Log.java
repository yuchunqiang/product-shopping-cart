package com.fh.product.aop;

import java.security.PrivateKey;
import java.util.Date;


public class Log {

    private String userid;
    private String username;
    private String ipaddress;
    private String classname;
    private String methodname;
    private Date addtime;
    private Date excutetime;
    private String description;
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getExcutetime() {
        return excutetime;
    }

    public void setExcutetime(Date excutetime) {
        this.excutetime = excutetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Log{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", classname='" + classname + '\'' +
                ", methodname='" + methodname + '\'' +
                ", addtime=" + addtime +
                ", excutetime=" + excutetime +
                ", description='" + description + '\'' +
                '}';
    }
}
