package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.CantidadMontoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.MayorVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.dto.ProductoVentaDTO;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Producto;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Venta;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository.ProductoRepository;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository repoVenta;
    @Autowired
    private ProductoService productoService;

    @Override
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = repoVenta.findAll();
        return listaVentas;
    }

    @Override
    public Venta saveVenta(Venta venta) {

        Double totalCalculado = 0.0;

        boolean ventaRealizada = false;

        for (Producto prod : venta.getProductos()) {

            if(prod.getStock() > 0){

                totalCalculado = totalCalculado + (prod.getPrecio() * prod.getCantidad());

                venta.setTotal(totalCalculado);

                prod.setStock(prod.getStock() - prod.getCantidad());

                productoService.saveProducto(prod);

                repoVenta.save(venta);

                ventaRealizada = true;

            }else{
                ventaRealizada = false;

            }

        }

        if(ventaRealizada){
            return venta;
        }else{
            return null;
        }

    }

    @Override
    public void deleteVenta(Long id_venta) {
        repoVenta.deleteById(id_venta);
    }

    @Override
    public Venta findVenta(Long id_venta) {
        return repoVenta.findById(id_venta).orElse(null);
    }

    @Override
    public List<Venta> findFecha(LocalDate fecha) {
        if(fecha == null){
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        return repoVenta.findByFecha(fecha);
    }

    @Override
    public Venta editVenta(Long id_venta, Venta venta) {

        Double totalCalculado = 0.0;

        boolean ventaRealizada = false;

        for (Producto prod : venta.getProductos()) {

            if(prod.getStock() > 0){

                totalCalculado = totalCalculado + (prod.getPrecio() * prod.getCantidad());

                venta.setTotal(totalCalculado);

                prod.setStock(prod.getStock() - prod.getCantidad());

                productoService.saveProducto(prod);

                repoVenta.save(venta);

                ventaRealizada = true;

            }else{
                ventaRealizada = false;

            }

        }

        if(ventaRealizada){
            return venta;
        }else{
            return null;
        }

    }

    @Override
    public ProductoVentaDTO ProductosPorVenta(Long id_venta) {
        ProductoVentaDTO venProdDTO = new ProductoVentaDTO ();
        Venta venta = this.findVenta(id_venta);
        venProdDTO.setId_venta(venta.getId_venta());
        venProdDTO.setListaProductos(venta.getProductos());

        return venProdDTO;
    }

    //6.
    @Override
    public String sumaCantVentDia(LocalDate fecha) {

        int totalCantidad = 0; //contador de cantidad de ventas
        Double totalCalculado = 0.0;

        //instacia DTO para modificar y obtener las variables de cantidad y monto total
        CantidadMontoVentaDTO canMonProdDTO = new CantidadMontoVentaDTO ();
        //lista de objetos ventas obtenidas en una fecha en especifico
        List<Venta> venta = this.findFecha(fecha);

        //recorrer la lista de ventas obtenidas por fecha especifica
        for  (int i= 0; i < venta.size(); i++) {
            //recorrer las ventas obteniendo sus productos y los objs productos se guardan en la variable prod para ir recorriendo
            for (Producto prod : venta.get(i).getProductos()) {
                //suema iterativa tanto de cantidad como de monto
                totalCantidad = totalCantidad + prod.getCantidad();//1 = 5 prod, 2 = 15
                totalCalculado = totalCalculado + (prod.getPrecio() * prod.getCantidad());//1=5000 * 5 = 25000 2, 2000 * 2 = 4000 = 29000
            }

        }

        canMonProdDTO.setCantidad(totalCantidad);
        canMonProdDTO.setMontoTotal(totalCalculado);

        return "La cantidad de ventas fue de: "+canMonProdDTO.getCantidad()+" unidades"+" y el monto total es de: "+canMonProdDTO.getMontoTotal() +" registradas el día: "+fecha;
    }

    //7.
    @Override
    public MayorVentaDTO mayorVenta() {

        //instancia vacia de obj mayor para setear posteriormente los datos con la venta mayor
        MayorVentaDTO mayor =  new MayorVentaDTO();
        //obj venta vacio para setear con el for
        Venta ventaMayor = new Venta();

        int cantidadMayor = 0;
        int cantidadProductos = 0;

        //establecemos el ventaMayor como el primer objeto y monto de la lista de ventas para proceder a comprobar
        ventaMayor.setTotal(traerVentas().get(0).getTotal());

        //recorrido de ventas
        for (int i = 0; i < traerVentas().size(); i++) {
            if(traerVentas().get(i).getTotal() > ventaMayor.getTotal()){
                ventaMayor.setTotal(traerVentas().get(i).getTotal());
                cantidadMayor = i;

            }
        }

        for (int j = 0; j < traerVentas().get(cantidadMayor).getProductos().size(); j++) {
            cantidadProductos = cantidadProductos + traerVentas().get(cantidadMayor).getProductos().get(j).getCantidad();
        }

        //seteamos variables de objeto MayorVentaDTO mayor
        mayor.setId_venta(traerVentas().get(cantidadMayor).getId_venta());
        mayor.setTotal(traerVentas().get(cantidadMayor).getTotal());
        mayor.setCantidadProductos(cantidadProductos);
        mayor.setNombre(traerVentas().get(cantidadMayor).getUnCliente().getNombre());
        mayor.setApellido(traerVentas().get(cantidadMayor).getUnCliente().getApellido());

        return mayor;
    }

}
