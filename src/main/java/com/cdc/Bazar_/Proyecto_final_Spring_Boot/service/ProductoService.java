package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repoProducto;

    @Override
    public List<Producto> traerProductos() {

        List<Producto> listaProductos = repoProducto.findAll();
        return listaProductos;

    }

    @Override
    public Producto saveProducto(Producto prod) {

        return repoProducto.save(prod);

    }

    @Override
    public void deleteProducto(Long id_prod) {

        repoProducto.deleteById(id_prod);

    }

    @Override
    public Producto findProducto(Long id_prod) {

        return repoProducto.findById(id_prod).orElse(null);

    }

    @Override
    public Producto editProducto(Long id_prod, Producto prod) {

        return this.saveProducto(prod);

    }

}
