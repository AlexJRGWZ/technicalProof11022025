package com.proof.technicalProof.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TECHNICALPROOF_GROUPS")
public class TPGroupsModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer group_id;

    private String group_name;
    
    @OneToMany(mappedBy = "tpGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<TPProductsModel> tpproducts;
    
    public TPGroupsModel() {}
    public TPGroupsModel(Integer group_id,String group_name,List<TPProductsModel> tpproducts) {
    	this.group_id = group_id;
    	this.group_name = group_name;
    	this.tpproducts = tpproducts;
    }
    
    ///////////
    //SETTERS//
    ///////////
    public void setGroup_id(Integer group_id) {
    	this.group_id = group_id;
    }
    public void setGroup_name(String group_name) {
    	this.group_name = group_name;
    }
    public void setTpproducts(List<TPProductsModel> tpproducts) {
    	this.tpproducts = tpproducts;
    }
    
    ///////////
    //GETTERS//
    ///////////
    public Integer getGroup_id() {
    	return this.group_id;
    }
    public String getGroup_name() {
    	return this.group_name;
    }
    public List<TPProductsModel> getTPProducts(){
    	return this.tpproducts;
    }
}
