package com.proof.technicalProof.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPGroupsModel;
import com.proof.technicalProof.repositorys.TPGroupsRepository;
import com.proof.technicalProof.services.TPGroupsServices;

@Service
public class TPGroupsServicesImpl implements TPGroupsServices{
	@Autowired
	TPGroupsRepository tpGroupsRepository;

	@Override
	public List<TPGroupsModel> obtainAllGroups() {
		try{
			return tpGroupsRepository.findAll();
		}catch(Exception e) {
    		System.err.println("ERROR on TPGroupsServicesImpl:obtainAllGroups: \n ");
    		e.printStackTrace();
    		return null;
    	}
	}
	
	
}
