package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.CatOperacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatOperacionRepository extends JpaRepository<CatOperacion, String> {

}
