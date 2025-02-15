package com.proof.technicalProof.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proof.technicalProof.daos.TPProductsDAO;
import com.proof.technicalProof.dtos.TPProductsDTO;
import com.proof.technicalProof.models.TPProductsModel;
import com.proof.technicalProof.services.TPProductsServices;

@RestController
@RequestMapping("/api/products")
public class TPProductsController {
	@Autowired
    private TPProductsServices tpProductsServices;

    @GetMapping("/all")
    public List<TPProductsDTO> obtainAllGroups() {
    	try{
    		List<TPProductsModel> listTPProductsModel = tpProductsServices.obtainAllProducts();
    		return this.convertFromTPProductsModelListToTPProductsDTOList(listTPProductsModel);
    	}catch(Exception e) {
    		System.err.println("ERROR on TPProductsController:obtainAllGroups: \n");
    		e.printStackTrace();
    		return null;
    	}
    }
    
    @GetMapping("/findByBrandIdAndProductIdAndStartDate/{brand_id}/{product_id}/{start_date}")
    public List<TPProductsDAO> findByBrandIdAndProductIdAndStartDate(@PathVariable Integer brand_id, @PathVariable Integer product_id, @PathVariable LocalDateTime start_date) {
    	try{
    		List<TPProductsModel> listTPProductsModel = tpProductsServices.findByBrandIdAndProductIdAndStartDate(brand_id,product_id,start_date);
	    	List<TPProductsDTO> listTPProductsDTO = this.convertFromTPProductsModelListToTPProductsDTOList(listTPProductsModel);
	    	return this.convertFromTPProductsDTOListToTPProductsDAOList(listTPProductsDTO);
    	}catch(Exception e) {
    		System.err.println("ERROR on TPProductsController:findByBrandIdAndProductIdAndStartDate: \n");
    		e.printStackTrace();
    		return null;
    	}
    }
    
    private List<TPProductsDTO> convertFromTPProductsModelListToTPProductsDTOList(List<TPProductsModel> listTPProductsModel){
    	List<TPProductsDTO> listTPProductsDTO = new ArrayList<TPProductsDTO>();
    	for(int i = 0; i < listTPProductsModel.size(); i++) {
    		TPProductsModel productis = listTPProductsModel.get(i);
    		TPProductsDTO productsDTOi = new TPProductsDTO();
    		productsDTOi.setStart_date(productis.getStart_date());
    		productsDTOi.setEnd_date(productis.getEnd_date());
    		productsDTOi.setCurr(productis.getCurr());
    		productsDTOi.setPrice(productis.getPrice());
    		productsDTOi.setPrice_list(productis.getPrice_list());
    		productsDTOi.setPriority(productis.getPriority());
    		productsDTOi.setProduct_id(productis.getProduct_id());
    		productsDTOi.setBrand_id(productis.getTpGroup().getGroup_id());
    		listTPProductsDTO.add(productsDTOi);
    	}
    	return listTPProductsDTO;
    }
    
    private List<TPProductsDAO> convertFromTPProductsDTOListToTPProductsDAOList(List<TPProductsDTO> listTPProductsDTO){
    	List<TPProductsDAO> listTPProductsDAO = new ArrayList<TPProductsDAO>();
    	for(int i = 0; i < listTPProductsDTO.size(); i++) {
    		TPProductsDTO productsDTOi = listTPProductsDTO.get(i);
    		TPProductsDAO productsDAOi = new TPProductsDAO();
    		productsDAOi.setStart_date(productsDTOi.getStart_date());
    		productsDAOi.setEnd_date(productsDTOi.getEnd_date());
    		productsDAOi.setPrice(productsDTOi.getPrice());
    		productsDAOi.setPrice_list(productsDTOi.getPrice_list());
    		productsDAOi.setProduct_id(productsDTOi.getProduct_id());
    		productsDAOi.setBrand_id(productsDTOi.getBrand_id());
    		listTPProductsDAO.add(productsDAOi);
    	}
    	return listTPProductsDAO;
    }
}
