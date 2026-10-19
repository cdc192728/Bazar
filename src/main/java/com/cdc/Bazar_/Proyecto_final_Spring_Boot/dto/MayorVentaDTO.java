package com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MayorVentaDTO {

    private Long id_venta;//venta
    private Double total;//venta
    private int cantidadProductos;//producto
    private String nombre;//cliente
    private String apellido;

}
