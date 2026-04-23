package org.example.dao;

import org.example.model.Veterinaria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VeterinariaDAO {
    private final JdbcTemplate jdbcTemplate;

    public VeterinariaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Veterinaria> veterinariaRowMapper =(rs,rowNum) -> {
        Veterinaria veterinaria = new Veterinaria();

        veterinaria.setId_veterinaria(rs.getInt("id_veterinaria"));
        veterinaria.setNombre(rs.getString("nombre"));
        veterinaria.setApellido(rs.getString("apellido"));
        veterinaria.setMatricula(rs.getInt("matricula"));
        veterinaria.setEspecialidad(rs.getString("especialidad"));
        veterinaria.setTelefono(rs.getString("telefono"));
        veterinaria.setEmail(rs.getString("email"));

        return veterinaria;
    };

    public List<Veterinaria> listarVeterinarias() {
        String sql = """
                SELECT * FROM veterinaria
                ORDER BY id_veterinaria;
                """;
        return jdbcTemplate.query(sql, veterinariaRowMapper);
    }

    public Optional<Veterinaria> buscarPorId(Integer id) {
        String sql = """
                SELECT * FROM veterinaria
                WHERE id_veterinaria = ?;
                """;
        List<Veterinaria> veterinarias = jdbcTemplate.query(sql, veterinariaRowMapper, id);
        return veterinarias.stream().findFirst();
    }

    public int crearVeterinaria(Veterinaria veterinaria) {
        String sql = """
                INSERT INTO veterinaria(nombre, apellido, matricula, especialidad, telefono, email)
                VALUES (?, ?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql,
                veterinaria.getNombre(),
                veterinaria.getApellido(),
                veterinaria.getMatricula(),
                veterinaria.getEspecialidad(),
                veterinaria.getTelefono(),
                veterinaria.getEmail());
    }

    public int actualizarVeterinaria(Integer id_veterinaria, Veterinaria veterinaria) {
        String sql = """
                UPDATE veterinaria
                SET nombre = ?, apellido = ?, matricula = ?, especialidad = ?, telefono = ?, email = ?
                WHERE id_veterinaria = ?;
                """;
        return jdbcTemplate.update(sql,id_veterinaria);
    }

    public int eliminarVeterinaria(Integer id) {
        String sql = """
                DELETE veterinaria
                WHERE id_veterinaria = ?;
                """;
        return jdbcTemplate.update(sql,id);
    }
}
