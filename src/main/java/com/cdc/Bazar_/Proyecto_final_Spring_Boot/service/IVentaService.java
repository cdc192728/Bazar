package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.CantidadMontoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.MayorVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.ProductoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //lectura
    public List<Venta> traerVentas();

    //alta
    public Venta saveVenta(Venta venta);

    //baja
    public void deleteVenta(Long id_venta);

    //lectura de un solo objeto
    public Venta findVenta(Long id_venta);

    //edición/modificación
    public Venta editVenta(Long id_venta, Venta venta);

    //obtener productos por venta
    public ProductoVentaDTO ProductosPorVenta(Long id_venta);

    //suma, cantidad total de una venta en un determinado día
    public String sumaCantVentDia(LocalDate fecha);

    public List<Venta> findFecha(LocalDate fecha);

    public MayorVentaDTO mayorVenta();

}
