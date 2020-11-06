package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.CatCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatCuentaRepository extends JpaRepository<CatCuenta, String> {

}
