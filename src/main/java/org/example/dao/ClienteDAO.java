package org.example.dao;

import org.example.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteDAO {
    private final JdbcTemplate jdbcTemplate;

    public ClienteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Cliente> clienteRowMapper = (rs, rowNum) -> {
        Cliente cliente = new Cliente();

        cliente.setId_cliente(rs.getInt("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setActivo(rs.getBoolean("activo"));

        return cliente;
    };

    public List<Cliente> listarClientes(){
        String sql = """
                SELECT id_cliente, nombre, apellido, email, telefono FROM cliente
                WHERE activo = true
                ORDER BY id_cliente;
                """;
        return jdbcTemplate.query(sql, clienteRowMapper);
    }

    public Optional<Cliente> buscarPorId(Integer id_cliente){
        String sql = """
                SELECT id_cliente, nombre, apellido, email, telefono FROM cliente
                WHERE id_cliente = ? AND activo = true;
                """;
        List<Cliente> clientes = jdbcTemplate.query(sql, clienteRowMapper, id_cliente);
        return clientes.stream().findFirst();
    }

    public int crearCliente(Cliente cliente){
        String sql = """
                INSERT INTO clientes(nombre, apellido, email, telefono, direccion)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        return jdbcTemplate.update(sql,
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion());
    }

    public int actualizarCliente(Integer id_cliente, Cliente cliente){
        String sql = """
                UPDATE clientes
                SET nombre = ?, apellido = ?, email = ?, telefono = ?, direccion = ?
                WHERE id_cliente = ? AND activo = TRUE;"
                """;
        return jdbcTemplate.update(sql, id_cliente);
    }

    public int borrarLogico(Integer id_cliente){
        String sql = """
               UPDATE clientes
               SET activo = FALSE
               WHERE id_cliente = ? AND activo = TRUE;
               """;
        return jdbcTemplate.update(sql, id_cliente);
    }
}
