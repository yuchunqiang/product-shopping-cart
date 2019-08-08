package com.fh.product.bean;

import java.io.Serializable;

public class Classify implements Serializable {
    private String classifyId;
    private String classifyName;
    private String largeClassId;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getLargeClassId() {
        return largeClassId;
    }

    public void setLargeClassId(String largeClassId) {
        this.largeClassId = largeClassId;
    }
}
