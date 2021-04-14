package com.cts.training.SeriesModelService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ExternalEntities.entity.ModelEntity;

//import com.cts.training.SeriesModelService.Entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer>{
	List<ModelEntity> findBySeriesId(Integer seriesId);
}
