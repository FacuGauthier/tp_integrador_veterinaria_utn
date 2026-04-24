package org.example.service;

import org.example.dao.VeterinariaDAO;
import org.example.model.Veterinaria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinariaService {
    private final VeterinariaDAO veterinariaDAO;

    public VeterinariaService(VeterinariaDAO veterinariaDAO) {
        this.veterinariaDAO = veterinariaDAO;
    }

    public List<Veterinaria> listarVeterinarias(){
        return veterinariaDAO.listarVeterinarias();
    }

    public Optional<Veterinaria> buscarPorId(Integer id){
        return  veterinariaDAO.buscarPorId(id);
    }

    public boolean crearVeterinaria(Veterinaria veterinaria){
        int filasAfectadas = veterinariaDAO.crearVeterinaria(veterinaria);
        return filasAfectadas > 0;
    }

    public boolean actualizarVeterinaria(Integer id, Veterinaria veterinaria){
        int filasAfectadas = veterinariaDAO.actualizarVeterinaria(id,veterinaria);
        return  filasAfectadas > 0;
    }

    public boolean eliminarVeterinaria(Integer id){
        int filasAfectadas  = veterinariaDAO.eliminarVeterinaria(id);
        return filasAfectadas > 0;
    }
}
