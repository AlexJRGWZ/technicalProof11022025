package com.proof.technicalProof.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPGroupsModel;

@Service
public interface TPGroupsServices {
	/**
	 * Method to obtain all groups on model form from database
	 * @return list with all the groups on database on model form
	 */
	List<TPGroupsModel> obtainAllGroups();
	
}
