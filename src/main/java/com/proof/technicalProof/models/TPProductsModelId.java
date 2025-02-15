package com.proof.technicalProof.models;

public class TPProductsModelId{
    private Integer price_list;
    private Integer product_id;

    // Constructor
    public TPProductsModelId() {}
    public TPProductsModelId(Integer price_list, Integer product_id) {
        this.price_list = price_list;
        this.product_id = product_id;
    }

    // Getters y Setters
    public void setPrice_list(Integer price_list) {
    	this.price_list = price_list;
    }
    public void setProduct_id(Integer product_id) {
    	this.product_id = product_id;
    }
    
    public Integer getProduct_id() {
    	return this.product_id;
    }
    public Integer getPrice_list() {
    	return this.price_list;
    }
}
