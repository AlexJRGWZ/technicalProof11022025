package com.proof.technicalProof.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proof.technicalProof.dtos.TPGroupsDTO;
import com.proof.technicalProof.models.TPGroupsModel;
import com.proof.technicalProof.services.TPGroupsServices;

@RestController
@RequestMapping("/api/groups")
public class TPGroupsController {
	@Autowired
    private TPGroupsServices tpGroupsServices;

    @GetMapping("/all")
    public List<TPGroupsDTO> obtainAllGroups() {
        try{
        	List<TPGroupsModel> tpGroupsModel = tpGroupsServices.obtainAllGroups();
            return this.convertListTPGroupsModelToDTO(tpGroupsModel);
        }catch(Exception e) {
    		System.err.println("ERROR on TPGroupsController:obtainAllGroups: \n ");
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    //CONVERT TPGROUPSMODEL TO TPGROUPSDTO
    private List<TPGroupsDTO> convertListTPGroupsModelToDTO(List<TPGroupsModel> listTPGroupsModel){
    	List<TPGroupsDTO> listTPGroupsDTO = new ArrayList<TPGroupsDTO>();
    	for(int i = 0; i < listTPGroupsModel.size(); i++) {
    		TPGroupsModel groupi = listTPGroupsModel.get(i);
    		TPGroupsDTO groupDTOi = new TPGroupsDTO();
    		groupDTOi.setGroup_id(groupi.getGroup_id());
    		groupDTOi.setGroup_name(groupi.getGroup_name());
    		listTPGroupsDTO.add(groupDTOi);
    	}
    	return listTPGroupsDTO;
    }
}
