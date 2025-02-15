package com.proof.technicalProof.repositorys;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proof.technicalProof.models.TPProductsModel;

@Repository
public interface TPProductsRepository extends JpaRepository<TPProductsModel, Long>  {
	
	/**
	 * Method to launch a query around of database
	 * This query will be, with the specifications, the next:
	 *     SELECT *
	 *     FROM TECHNICALPROOF_PRODUCTS
	 *     WHERE brand_id = :brand_id AND product_id = :product_id AND start_date >= :apply_date AND :apply_date < end_date
	 * @param brand_id id of the group
	 * @param product_id id of the product
	 * @param apply_date date when this query is launched (with hour) 
	 * @return list of products (on model form) that are coincidents with the query launched
	 */
	@Query(value="SELECT * FROM TECHNICALPROOF_PRODUCTS WHERE brand_id = :brand_id AND product_id = :product_id AND start_date >= :apply_date AND :apply_date < end_date",nativeQuery=true)
	List<TPProductsModel> findByBrandIdAndProductIdAndStartDate(@Param("brand_id") Integer brand_id,@Param("product_id") Integer product_id,@Param("apply_date") LocalDateTime apply_date);
}
