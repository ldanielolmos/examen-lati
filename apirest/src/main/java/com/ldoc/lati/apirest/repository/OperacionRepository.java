package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

}
