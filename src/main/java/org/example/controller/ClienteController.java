package org.example.controller;

import org.example.model.Cliente;
import org.example.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        boolean creado = clienteService.crearCliente(cliente);
        if (creado) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado correctamente");
        }

        return ResponseEntity.badRequest().body("No se pudo crear el cliente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(
            @PathVariable Integer id,
            @RequestBody Cliente cliente
    ) {
        boolean actualizado = clienteService.actualizarCliente(cliente);
        if (actualizado) {
            return ResponseEntity.ok("Cliente actualizado correctamente");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogico(@PathVariable Integer id) {
        boolean eliminado = clienteService.eliminarLogico(id);
        if (eliminado) {
            return ResponseEntity.ok("Cliente eliminado correctamente");
        }

        return ResponseEntity.notFound().build();
    }
}
