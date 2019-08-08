package com.fh.product.bean;

import java.io.Serializable;

public class ChildClass implements Serializable {
    private String childClassId;
    private String childClassName;
    private String largeClassId;
    private String classifyId;

    public String getChildClassId() {
        return childClassId;
    }

    public void setChildClassId(String childClassId) {
        this.childClassId = childClassId;
    }

    public String getChildClassName() {
        return childClassName;
    }

    public void setChildClassName(String childClassName) {
        this.childClassName = childClassName;
    }

    public String getLargeClassId() {
        return largeClassId;
    }

    public void setLargeClassId(String largeClassId) {
        this.largeClassId = largeClassId;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }
}
