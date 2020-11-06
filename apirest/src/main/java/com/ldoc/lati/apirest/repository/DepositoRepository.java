package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Integer> {

}
