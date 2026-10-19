package com.cdc.Bazar_.Proyecto_final_Spring_Boot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    private LocalDate fecha;
    private Double total;

    @OneToMany(cascade = CascadeType.MERGE,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Producto> productos;

    @OneToOne(cascade = CascadeType.MERGE,
            orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn (name="id_cli", referencedColumnName = "id_cli")
    private Cliente unCliente;

}
