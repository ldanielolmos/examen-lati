package com.ldoc.lati.apirest.repository;

import com.ldoc.lati.apirest.model.CatTipoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatTipoCreditoRepository extends JpaRepository<CatTipoCredito, String> {

}
