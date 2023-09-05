package com.project.performance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.performance.domain.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long>{
	
}
