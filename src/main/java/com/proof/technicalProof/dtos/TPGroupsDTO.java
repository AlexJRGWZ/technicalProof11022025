package com.proof.technicalProof.dtos;

public class TPGroupsDTO {
	private Integer group_id;
	private String group_name;
	
	public TPGroupsDTO() {}
    public TPGroupsDTO(Integer group_id,String group_name) {
    	this.group_id = group_id;
    	this.group_name = group_name;
    }
	
	///////////
	//SETTERS//
	///////////
	public void setGroup_id(Integer group_id) {this.group_id = group_id;}
	public void setGroup_name(String group_name) {this.group_name = group_name;}
	
	///////////
	//GETTERS//
	///////////
	public Integer getGroup_id() {return this.group_id;}
	public String getGroup_name() {return this.group_name;}

}
