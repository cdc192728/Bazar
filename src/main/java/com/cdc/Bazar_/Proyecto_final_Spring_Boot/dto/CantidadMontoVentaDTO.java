package com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CantidadMontoVentaDTO {

    private Long id;
    private int cantidad;
    private Double montoTotal;

}
