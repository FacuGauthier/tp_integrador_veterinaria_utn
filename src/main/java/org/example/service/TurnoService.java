package org.example.service;

import org.example.dao.TurnoDAO;
import org.example.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoDAO turnoDAO;

    public TurnoService(TurnoDAO turnoDAO) {
        this.turnoDAO = turnoDAO;
    }

    public List<Turno> listarTurnos(){
        return  turnoDAO.listarTurnos();
    }

    public Optional<Turno> buscarTurno(Integer id){
        return turnoDAO.buscarTurno(id);
    }

    public List<Turno> listarTurnosPorVeterinaria(Integer id){
        return turnoDAO.listarTurnosPorVeterinario(id);
    }

    public List<Turno> listarTurnosPorCliente(Integer id){
        return turnoDAO.listarTurnosPorCliente(id);
    }

    public boolean crearTurno(Turno turno){
        int filas = turnoDAO.crearTurno(turno);
        return filas > 0;
    }

    public boolean actualizarTurno(Integer id, Turno turno){
        int filas =  turnoDAO.actualizarTurno(id,turno);
        return filas > 0;
    }

    public boolean eliminarTurno(Integer id){
        int filas = turnoDAO.cancelarTurno(id);
        return filas > 0;
    }
}

