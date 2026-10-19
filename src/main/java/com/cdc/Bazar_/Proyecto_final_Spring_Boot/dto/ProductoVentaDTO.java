package com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoVentaDTO {

    private Long id_venta;
    private List<Producto> listaProductos;

}
