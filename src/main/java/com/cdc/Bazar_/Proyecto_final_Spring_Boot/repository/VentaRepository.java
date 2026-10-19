package com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.CantidadMontoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Buscar una lista por fecha exacta
    List<Venta> findByFecha(LocalDate fecha);

    // Si solo esperas un único objeto
    //Optional<Venta> findByFecha(LocalDate fecha);

}
