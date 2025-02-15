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

	/**
	 * Method of the controller to obtain the DTOObjects of all the products on the database
	 * @return List with DTO of all the products of the database
	 */
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
    
    /**
     * EndPoint to obtain a list of DAO of the products with fields required (price_list,brand_id,price,brand_id,dates and product_id)
     * @param brand_id the group id
     * @param product_id the product id
     * @param apply_date the apply date for this query
     * @return list of products that results coincidents with the query realized
     */
    @GetMapping("/findByBrandIdAndProductIdAndStartDate/{brand_id}/{product_id}/{apply_date}")
    public List<TPProductsDAO> findByBrandIdAndProductIdAndStartDate(@PathVariable Integer brand_id, @PathVariable Integer product_id, @PathVariable LocalDateTime apply_date) {
    	try{
    		List<TPProductsModel> listTPProductsModel = tpProductsServices.findByBrandIdAndProductIdAndStartDate(brand_id,product_id,apply_date);
	    	List<TPProductsDTO> listTPProductsDTO = this.convertFromTPProductsModelListToTPProductsDTOList(listTPProductsModel);
	    	return this.convertFromTPProductsDTOListToTPProductsDAOList(listTPProductsDTO);
    	}catch(Exception e) {
    		System.err.println("ERROR on TPProductsController:findByBrandIdAndProductIdAndStartDate: \n");
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * Method to transform a list of model products on DTOs equivalents
     * @param listTPProductsModel list of model of products
     * @return list of DTOs of products equivalent at the list passed as param of models
     */
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
    
    /**
     * Method to transform a list of DTO products on DAOs equivalents
     * @param listTPProductsDTO list of DTO of products
     * @return list of DAOs of products equivalent at the list passed as param of DTOs
     */
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
