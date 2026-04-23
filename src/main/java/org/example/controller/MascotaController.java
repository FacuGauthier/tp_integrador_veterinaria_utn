package org.example.controller;

import org.example.model.Mascota;
import org.example.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<Mascota> listarMascotas(){
        return  mascotaService.listarMascotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarPorId(@PathVariable Integer id){
        return mascotaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> crearMascota(@RequestBody Mascota mascota){
        boolean creado = mascotaService.crearMascota(mascota);
        if(creado){
            return ResponseEntity.status(HttpStatus.CREATED).body("Mascota agregada correctamente.");
        }

        return  ResponseEntity.badRequest().body("Error al agregar mascota.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  actualizarMascota(
            @PathVariable Integer id,
            @RequestBody Mascota mascota
    ) {
        boolean actualizado = mascotaService.actualizarMascota(id, mascota);
        if(actualizado){
            return ResponseEntity.ok("Mascota actualizada correctamente.");
        }
        return ResponseEntity.badRequest().body("Error al actualizar mascota.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLogico(@PathVariable Integer id){
        boolean eliminado = mascotaService.eliminarLogico(id);
        if(eliminado){
            return ResponseEntity.ok("Mascota eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
