package com.proof.technicalProof.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proof.technicalProof.models.TPProductsModel;
import java.time.LocalDateTime;

@Service
public interface TPProductsServices {
	List<TPProductsModel> obtainAllProducts();
	List<TPProductsModel> findByBrandIdAndProductIdAndStartDate(Integer brand_id, Integer product_id, LocalDateTime start_date);
}
