package com.cdc.Bazar_.Proyecto_final_Spring_Boot.controller;

import com.cdc.Bazar_.Proyecto_final_Spring_Boot.model.Cliente;
import com.cdc.Bazar_.Proyecto_final_Spring_Boot.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerClientes(){

        return ResponseEntity.ok(clienteService.traerClientes());

    }

    //Traer Cliente por Id
    @GetMapping ("/clientes/traer/{id_cliente}")
    public Cliente traerCliente (@PathVariable Long id_cliente) {

        return clienteService.findCliente(id_cliente);
    }

    @PostMapping("/clientes/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cli){

        Cliente creado = clienteService.saveCliente(cli);

        return ResponseEntity.created(URI.create("/clientes/crear" + creado.getId_cli())).body(creado);

    }

    @PutMapping("/clientes/editar/{id_cli}")
    public ResponseEntity<Cliente> actualizarCliente (@PathVariable Long id_cli,
                                                      @RequestBody Cliente cli) {
        return ResponseEntity.ok(clienteService.editCliente(id_cli, cli));
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public ResponseEntity<Void> borrarProducto (@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

}
