package com.proof.technicalProof.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPGroupsModel;

@Service
public interface TPGroupsServices {
	List<TPGroupsModel> obtainAllGroups();
	
}
