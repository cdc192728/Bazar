package com.cdc.Bazar_.Proyecto_final_Spring_Boot.controller;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.CantidadMontoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.MayorVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.ProductoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Venta;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> traerVentas(){

        return ResponseEntity.ok(ventaService.traerVentas());

    }

    @PostMapping("/ventas/crear")
    public Venta crearVenta(@RequestBody Venta venta){

        return ventaService.saveVenta(venta);

    }

    //Traer Ventas por Id
    @GetMapping ("/ventas/traer/{id_venta}")
    public Venta traerVenta (@PathVariable Long id_venta) {

        return ventaService.findVenta(id_venta);
    }

    @PutMapping("/ventas/editar/{id_venta}")
    public Venta actualizarVenta (@PathVariable Long id_venta,
                                   @RequestBody Venta venta) {

        return ventaService.editVenta(id_venta, venta);
    }

    @DeleteMapping("/ventas/eliminar/{id}")
    public ResponseEntity<Void> borrarVenta (@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }

    //5 - Obtener los productos de una determinada venta
    @GetMapping ("/ventas/productos/{id_venta}")
    public ProductoVentaDTO productosPorVentas (@PathVariable Long id_venta) {
        return ventaService.ProductosPorVenta(id_venta);
    }

    //6 - Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping ("/ventas/{fecha}")
    public String sumaCantVentDia (@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        String v = ventaService.sumaCantVentDia(fecha);
        return v;
    }

    //7 - Obtener la venta con el monto más alto de todas
    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO mayorVenta () {
        return ventaService.mayorVenta();
    }

}
