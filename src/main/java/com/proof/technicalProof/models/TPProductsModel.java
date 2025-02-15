package com.proof.technicalProof.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TECHNICALPROOF_PRODUCTS")
@IdClass(TPProductsModelId.class) // Usar la clase de clave compuesta de la tabla
public class TPProductsModel {
	
    @Column(name = "start_date")
    private LocalDateTime start_date;
    
    @Column(name = "end_date")
    private LocalDateTime end_date;
    
    @Id
    @Column(name = "price_list")
    private Integer price_list; // Cambiado a Integer
    
    @Id
    @Column(name = "product_id") // Especifica el nombre de la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id; // Cambiado a Integer

    @Column(name = "priority")
    private Integer priority; // Cambiado a Integer
    
    @Column(name = "price")
    private BigDecimal price; // Cambiado a BigDecimal

    @Column(name = "curr")
    private String curr;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private TPGroupsModel tpGroup; // Asegúrate de que esta entidad esté bien definida

    public TPProductsModel() {}
    public TPProductsModel(LocalDateTime start_date, LocalDateTime end_date,Integer price_list,Integer product_id, Integer priority, BigDecimal price, String curr,TPGroupsModel tpGroup) {
    	this.start_date = start_date;
    	this.end_date = end_date;
    	this.price_list = price_list;
    	this.product_id = product_id;
    	this.priority = priority;
    	this.price = price;
    	this.curr = curr;
    	this.tpGroup = tpGroup;
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
    public TPGroupsModel getTpGroup() {return this.tpGroup;}
    
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
    public void setTpGroup(TPGroupsModel tpGroup) {this.tpGroup = tpGroup;}
    
}
