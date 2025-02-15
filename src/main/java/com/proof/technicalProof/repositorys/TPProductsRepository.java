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
	
	@Query(value="SELECT * FROM TECHNICALPROOF_PRODUCTS WHERE brand_id = :brand_id AND product_id = :product_id AND start_date >= :start_date AND :start_date < end_date",nativeQuery=true)
	List<TPProductsModel> findByBrandIdAndProductIdAndStartDate(@Param("brand_id") Integer brand_id,@Param("product_id") Integer product_id,@Param("start_date") LocalDateTime start_date);
}
