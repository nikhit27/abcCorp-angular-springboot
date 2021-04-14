package com.cts.coloraccessoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ExternalEntities.entity.ColorEntity;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Integer>{
	List<ColorEntity> findByModelId(Integer modelId);
	
}
