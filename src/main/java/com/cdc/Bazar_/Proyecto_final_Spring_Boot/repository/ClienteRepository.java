package com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {



}
