package org.example.dao;

import org.example.model.Mascota;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MascotaDAO {
    private final JdbcTemplate jdbcTemplate;

    public MascotaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Mascota> mascotaRowMapper = (rs, rowNum) -> {
        Mascota mascota = new Mascota();

        mascota.setId_mascota(rs.getInt("id_mascota"));
        mascota.setNombre(rs.getString("nombre"));
        mascota.setRaza(rs.getString("raza"));
        mascota.setEdad(rs.getInt("edad"));
        mascota.setPeso(rs.getBigDecimal("peso"));
        mascota.setId_cliente(rs.getInt("id_cliente"));

        return mascota;
    };

    public List<Mascota> listarMascotas(){
        String sql = """
                SELECT * FROM mascota
                WHERE activo = TRUE
                ORDER BY id_mascota;
                """;
        return jdbcTemplate.query(sql, mascotaRowMapper);
    }

    public Optional<Mascota> buscarPorId(Integer id_mascota){
        String sql = """
                SELECT * FROM mascota
                WHERE id_mascota = ? AND activo = TRUE;
                """;
        List<Mascota> mascota = jdbcTemplate.query(sql, mascotaRowMapper, id_mascota);
        return mascota.stream().findFirst();
    }

    public List<Mascota> buscarPorCliente(Integer id_cliente){
        String sql = """
                SELECT * FROM mascota
                WHERE id_cliente = ? AND activo = TRUE
                ORDER BY id_mascota;
                """;
        return jdbcTemplate.query(sql, mascotaRowMapper, id_cliente);
    }

    public int crearMascota(Mascota mascota){
        String sql = """
                INSERT INTO mascota (nombre, raza, edad, peso, id_cliente)
                VALUES (?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql,
                mascota.getNombre(),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getPeso(),
                mascota.getId_cliente());
    }

    public int actualizarMascota(Integer id_mascota, Mascota mascota){
        String sql = """
                UPDATE mascota
                SET nombre = ?, raza = ?, edad = ?, peso = ?, id_cliente = ?
                WHERE id_mascota = ?;
                """;
        return jdbcTemplate.update(sql,id_mascota);
    }

    public int borrarLogico(Integer id_mascota){
        String sql = """
                UPDATE mascota
                SET activo = FALSE
                WHERE id_mascota = ? AND activo = TRUE;
                """;
        return jdbcTemplate.update(sql,id_mascota);
    }
}
