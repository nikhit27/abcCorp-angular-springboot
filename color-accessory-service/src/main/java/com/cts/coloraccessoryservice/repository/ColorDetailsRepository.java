package com.cts.coloraccessoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ExternalEntities.entity.ColorDetailsEntity;

@Repository
public interface ColorDetailsRepository extends JpaRepository<ColorDetailsEntity, Integer>{

}
