package com.proof.technicalProof.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TPProductsDTO {
	
	private Integer brand_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
	private Integer price_list;
    private Integer product_id;
	private Integer priority;
	private BigDecimal price;
    private String curr;
	
	public TPProductsDTO() {}
	public TPProductsDTO(LocalDateTime start_date,LocalDateTime end_date,Integer price_list,
						Integer product_id, Integer priority, BigDecimal price, String curr,
						Integer brand_id) {
		this.start_date = start_date;
    	this.end_date = end_date;
    	this.price_list = price_list;
    	this.product_id = product_id;
    	this.priority = priority;
    	this.price = price;
    	this.curr = curr;
    	this.brand_id = brand_id;
	}
	
	///////////
	//GETTERS//
	///////////
	public LocalDateTime getStart_date() {return this.start_date;}
	public LocalDateTime getEnd_date() {return this.end_date;}
	public Integer getPrice_list() {return this.price_list;}
	public Integer getProduct_id() {return this.product_id;}
	public Integer getPriority() {return this.priority;}
	public BigDecimal getPrice() {return this.price;}
	public String getCurr() {return this.curr;}
	public Integer getBrand_id() {return this.brand_id;}
	
	////////////
	///SETTERS//
	////////////
	public void setStart_date(LocalDateTime start_date) {this.start_date = start_date;}
	public void setEnd_date(LocalDateTime end_date) {this.end_date = end_date;}
	public void setPrice_list(Integer price_list) {this.price_list = price_list;}
	public void setProduct_id(Integer product_id) {this.product_id = product_id;}
	public void setPriority(Integer priority) {this.priority = priority;}
	public void setPrice(BigDecimal price) {this.price = price;}
	public void setCurr(String curr) {this.curr = curr;}
	public void setBrand_id(Integer brand_id) {this.brand_id = brand_id;}
}
