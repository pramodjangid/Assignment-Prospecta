package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.model.ApiEntry;

@Repository
public interface ApiRepository extends JpaRepository<ApiEntry, Integer> {

}
