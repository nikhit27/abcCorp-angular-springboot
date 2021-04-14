package com.cts.training.SeriesModelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ExternalEntities.entity.SeriesEntity;

@Repository
public interface SeriesRepository extends JpaRepository<SeriesEntity, Integer>{

}
