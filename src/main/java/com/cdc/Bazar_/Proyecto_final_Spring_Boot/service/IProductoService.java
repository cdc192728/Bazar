package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;

import java.util.List;

public interface IProductoService {

    //lectura
    public List<Producto> traerProductos();

    //alta
    public Producto saveProducto(Producto prod);

    //baja
    public void deleteProducto(Long id_prod);

    //lectura de un solo objeto
    public Producto findProducto(Long id_prod);

    //edición/modificación
    public Producto editProducto(Long id_prod, Producto prod);

}
