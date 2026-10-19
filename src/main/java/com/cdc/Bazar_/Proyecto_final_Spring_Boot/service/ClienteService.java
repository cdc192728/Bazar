package com.cdc.Bazar_.Proyecto_final_Spring_Boot.service;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repoCliente;

    @Override
    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = repoCliente.findAll();
        return listaClientes;
    }

    @Override
    public Cliente saveCliente(Cliente cli) {
        return repoCliente.save(cli);
    }

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id_cli) {
        return repoCliente.findById(id_cli).orElse(null);
    }


    @Override
    public Cliente editCliente(Long id_cli, Cliente cli) {
        return this.saveCliente(cli);
    }

}
