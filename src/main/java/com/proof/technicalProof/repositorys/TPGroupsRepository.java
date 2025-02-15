package com.proof.technicalProof.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proof.technicalProof.models.TPGroupsModel;

@Repository
public interface TPGroupsRepository extends JpaRepository<TPGroupsModel, Long>  {

}
