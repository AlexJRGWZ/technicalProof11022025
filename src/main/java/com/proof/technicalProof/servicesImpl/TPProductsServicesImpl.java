package com.proof.technicalProof.servicesImpl;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPProductsModel;
import com.proof.technicalProof.repositorys.TPProductsRepository;
import com.proof.technicalProof.services.TPProductsServices;

@Service
public class TPProductsServicesImpl implements TPProductsServices{
	@Autowired
	TPProductsRepository tpProductsRepository;

	@Override
	public List<TPProductsModel> obtainAllProducts() {
		try{
			return tpProductsRepository.findAll();
		}catch(Exception e) {
	    	System.err.println("ERROR on TPProductsServicesImpl:obtainAllGroups: \n ");
	    	e.printStackTrace();
	    	return null;
	    }
	}

	@Override
	public List<TPProductsModel> findByBrandIdAndProductIdAndStartDate(Integer brand_id, Integer product_id, LocalDateTime apply_date) {
		try{
			return tpProductsRepository.findByBrandIdAndProductIdAndStartDate(brand_id, product_id, apply_date);
		}catch(Exception e) {
	    	System.err.println("ERROR on TPProductsServicesImpl:findByBrandIdAndProductIdAndStartDate: \n ");
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
}
