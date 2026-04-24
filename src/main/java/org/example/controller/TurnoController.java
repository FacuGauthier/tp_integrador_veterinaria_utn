package org.example.controller;

import org.example.model.Turno;
import org.example.service.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<Turno> listarTurnos(){
        return turnoService.listarTurnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id){
        return turnoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id_veterinaria}")
    public List<Turno> listarTurnosPorVeterinaria(@PathVariable Integer id_veterinaria){
        return turnoService.listarTurnosPorVeterinaria(id_veterinaria);
    }

    @GetMapping("/{id_cliente}")
    public List<Turno> listarTurnosPorCliente(Integer id_cliente){
        return turnoService.listarTurnosPorCliente(id_cliente);
    }

    @PostMapping
    public ResponseEntity<String> crearTurno(@RequestBody Turno turno){
        boolean creado =  turnoService.crearTurno(turno);
        if(creado){
            return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado con exito");
        }
        return ResponseEntity.badRequest().body("Turno no creado con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTurno(
            @PathVariable Integer id,
            @RequestBody Turno turno
    ){
        boolean actualizado = turnoService.actualizarTurno(id, turno);
        if(actualizado){
            return ResponseEntity.ok("Turno actualizado con exito");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        boolean eliminado = turnoService.eliminarTurno(id);
        if(eliminado){
            return ResponseEntity.ok("Turno eliminado con exito");
        }
        return ResponseEntity.notFound().build();
    }
}
