package com.fh.product.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;
    private String productName;
    private Double productPrice;
    private String largeClassId;
    private String classifyId;
    private String childClassId;
    private String productImage;
    private Integer num;
    private Double productPriceNmu;
    private String productIds;
//    private Integer numSum;
//
//    public Integer getNumSum() {
//        return numSum;
//    }
//
//    public void setNumSum(Integer numSum) {
//        this.numSum = numSum;
//    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public Double getProductPriceNmu() {
        return productPriceNmu;
    }

    public void setProductPriceNmu(Double productPriceNmu) {
        this.productPriceNmu = productPriceNmu;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", largeClassId='" + largeClassId + '\'' +
                ", classifyId='" + classifyId + '\'' +
                ", childClassId='" + childClassId + '\'' +
                ", productImage='" + productImage + '\'' +
                ", num=" + num +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
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

    public String getChildClassId() {
        return childClassId;
    }

    public void setChildClassId(String childClassId) {
        this.childClassId = childClassId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
