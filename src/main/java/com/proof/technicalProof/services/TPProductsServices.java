package com.proof.technicalProof.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPProductsModel;
import java.time.LocalDateTime;

@Service
public interface TPProductsServices {
	/**
	 * Method to obtain all the products from database on model form
	 * @return list of all products on model form
	 */
	List<TPProductsModel> obtainAllProducts();
	
	/**
	 * Method to obtain the products that are coincidents with the query on the repository
	 * @param brand_id branch_id used on the query, refered at the group
	 * @param product_id product id of the product
	 * @param apply_date the date (with hour) when the query is applied
	 * @return list of the products coincidents with the params (when the query is launched)
	 */
	List<TPProductsModel> findByBrandIdAndProductIdAndStartDate(Integer brand_id, Integer product_id, LocalDateTime apply_date);
}
