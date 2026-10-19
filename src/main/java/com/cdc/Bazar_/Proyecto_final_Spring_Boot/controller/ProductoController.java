package com.cdc.Bazar_.Proyecto_final_Spring_Boot.controller;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.service.IClienteService;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> traerProductos(){

        return ResponseEntity.ok(productoService.traerProductos());

    }

    @PostMapping("/productos/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto prod){

        Producto creado = productoService.saveProducto(prod);

        return ResponseEntity.created(URI.create("/productos/crear" + creado.getId_prod())).body(creado);

    }

    //Traer Producto por Id
    @GetMapping ("/productos/traer/{id_producto}")
    public Producto traerProducto (@PathVariable Long id_producto) {

        return productoService.findProducto(id_producto);
    }

    @PutMapping("/productos/editar/{id_prod}")
    public ResponseEntity<Producto> actualizarProducto (@PathVariable Long id_prod,
                                                      @RequestBody Producto prod) {
        return ResponseEntity.ok(productoService.editProducto(id_prod, prod));
    }

    @DeleteMapping("/productos/eliminar/{id}")
    public ResponseEntity<Void> borrarProducto (@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    // 4. Stock menor a 5
    @GetMapping ("/productos/falta_stock")
    public List<Producto> faltaStockProducto () {

        List<Producto> listaProductos = this.traerProductos().getBody();// guarda todas las mascotas en esta lista haciendouso del metodo local declarado anteriormente
        List<Producto> listaFaltaStock = new ArrayList<Producto>();// lista para guardar los caniches (mascota)


        for (Producto prod:listaProductos) {
            if (prod.getStock() < 5) {
                listaFaltaStock.add(prod);//añade el elemento a la lista si cumple las dos condiciones
            }
        }
        return listaFaltaStock;

    }
    
    

}
