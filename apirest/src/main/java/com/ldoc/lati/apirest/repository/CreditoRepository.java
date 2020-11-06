package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {

}
