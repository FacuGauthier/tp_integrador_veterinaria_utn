package org.example.service;

import org.example.dao.MascotaDAO;
import org.example.model.Mascota;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    private final MascotaDAO mascotaDAO;

    public MascotaService(MascotaDAO mascotaDAO){
        this.mascotaDAO = mascotaDAO;
    }

    public List<Mascota> listarMascotas(){
        return mascotaDAO.listarMascotas();
    }

    public Optional<Mascota> buscarPorId(Integer id_mascota){
        return mascotaDAO.buscarPorId(id_mascota);
    }

    public List<Mascota> buscarPorCliente(Integer id_cliente){
        return mascotaDAO.buscarPorCliente(id_cliente);
    }

    public boolean crearMascota(Mascota mascota){
        int filasAfectadas = mascotaDAO.crearMascota(mascota);
        return  filasAfectadas > 0;
    }

    public boolean actualizarMascota(Integer id_mascota, Mascota mascota){
        int filasAfectadas = mascotaDAO.actualizarMascota(id_mascota, mascota);
        return  filasAfectadas > 0;
    }

    public boolean eliminarLogico(Integer id_mascota){
        int filasAfectadas = mascotaDAO.borrarLogico(id_mascota);
        return  filasAfectadas > 0;
    }
}
