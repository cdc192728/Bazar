package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;

import java.util.List;

public interface IClienteService {

    //método para traer a todas las mascota
    //lectura
    public List<Cliente> traerClientes();

    //alta
    public Cliente saveCliente(Cliente cli);

    //baja
    public void deleteCliente(Long id_cli);

    //lectura de un solo objeto
    public Cliente findCliente(Long id_cli);

    //edición/modificación
    public Cliente editCliente(Long id_cli, Cliente cli);

//    public List<Cliente> getCaniches();

//    public List<MascoDuenioDTO> getMascoDuenios();

}
