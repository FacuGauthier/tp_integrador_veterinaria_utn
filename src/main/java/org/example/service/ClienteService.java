package org.example.service;

import org.example.dao.ClienteDAO;
import org.example.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> listarClientes(){
        return clienteDAO.listarClientes();
    }

    public Optional<Cliente> buscarPorId(Integer id_cliente){
        return clienteDAO.buscarPorId(id_cliente);
    }

    public boolean crearCliente(Cliente cliente){
        int filasAfectadas = clienteDAO.crearCliente(cliente);
        return filasAfectadas > 0;
    }

    public boolean actualizarCliente(Integer id, Cliente cliente){
        int filasAfectadas = clienteDAO.actualizarCliente(id,cliente);
        return filasAfectadas > 0;
    }

    public boolean eliminarLogico(Integer id_cliente){
        int filasAfectadas = clienteDAO.borrarLogico(id_cliente);
        return filasAfectadas > 0;
    }

}
