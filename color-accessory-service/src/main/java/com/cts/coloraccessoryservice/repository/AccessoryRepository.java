package com.cts.coloraccessoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ExternalEntities.entity.AccessoryEntity;

@Repository
public interface AccessoryRepository extends JpaRepository<AccessoryEntity, Integer>{
	List<AccessoryEntity> findByModelId(Integer modelId);
}
