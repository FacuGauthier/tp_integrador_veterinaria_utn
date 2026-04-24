package org.example.controller;

import org.example.model.Cliente;
import org.example.model.Veterinaria;
import org.example.service.VeterinariaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarias")
public class VeterinariaController {
    private final VeterinariaService veterinariaService;

    public VeterinariaController(VeterinariaService veterinariaService) {
        this.veterinariaService = veterinariaService;
    }

    @GetMapping
    public List<Veterinaria> listarVeterinarias() {
        return veterinariaService.listarVeterinarias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> buscarPorId(@PathVariable Integer id) {
        return veterinariaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearVeterinaria(@RequestBody Veterinaria veterinaria) {
        boolean creado = veterinariaService.crearVeterinaria(veterinaria);
        if (creado) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Veterinaria creada correctamente.");
        }
        return ResponseEntity.badRequest().body("No se pudo crear la veterinaria.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarVeterinaria(
            @PathVariable Integer id,
            @RequestBody Veterinaria veterinaria
    ) {
        boolean actualizado = veterinariaService.actualizarVeterinaria(id, veterinaria);
        if (actualizado) {
            return ResponseEntity.ok("Veterinaria actualizada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<String> eliminarVeterinaria(@PathVariable Integer id) {
        boolean eliminado = veterinariaService.eliminarVeterinaria(id);
        if (eliminado) {
            return ResponseEntity.ok("Veterinaria eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
