package org.example.dao;

import org.example.model.Estado;
import org.example.model.Turno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TurnoDAO {
    private final JdbcTemplate jdbcTemplate;

    public TurnoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Turno> turnoRowMapper = (rs,rowNum) ->{
        Turno turno = new Turno();

        turno.setId_turno(rs.getInt("id_turno"));
        turno.setFecha(rs.getDate("fecha"));
        turno.setHora(rs.getTime("hora"));
        turno.setMotivo(rs.getString("motivo"));
        turno.setEstado(Estado.valueOf(rs.getString("estado")));
        turno.setId_cliente(rs.getInt("id_cliente"));
        turno.setId_veterinaria(rs.getInt("id_veterinaria"));
        turno.setId_mascota(rs.getInt("id_mascota"));

        return turno;
    };

    public List<Turno> listarTurnos(){
        String sql = """
                SELECT * FROM turno
                ORDER BY id_turno;
                """;
        return jdbcTemplate.query(sql, this.turnoRowMapper);
    }

    public Optional<Turno> buscarTurno(Integer id_turno){
        String sql = """
                SELECT * FROM turno
                WHERE id_turno = ?;
                """;
        List<Turno> turnos = jdbcTemplate.query(sql, this.turnoRowMapper, id_turno);
        return turnos.stream().findFirst();
    }

    public List<Turno> listarTurnosPorVeterinario(Integer id_veterinaria){
        String sql = """
                SELECT * FROM turno
                WHERE id_veterinaria = ?;
                """;
        return jdbcTemplate.query(sql, this.turnoRowMapper, id_veterinaria);
    }

    public List<Turno> listarTurnosPorCliente(Integer id_cliente){
        String sql = """
                SELECT * FROM turno
                WHERE id_cliente = ?;
                """;
        return jdbcTemplate.query(sql, this.turnoRowMapper, id_cliente);
    }

    public int crearTurno(Turno turno){
        String sql = """
                INSERT INTO turno(fecha, hora, motivo, estado, id_cliente, id_veterinaria, id_mascota)
                VALUES (?,?,?,?,?,?,?);
                """;
        return jdbcTemplate.update(sql,
                turno.getFecha(),
                turno.getHora(),
                turno.getMotivo(),
                turno.getEstado(),
                turno.getId_cliente(),
                turno.getId_veterinaria(),
                turno.getId_mascota());
    }

    public int actualizarTurno(Integer id_turno, Turno turno){
        String sql = """
                UPDATE turno
                SET fecha = ?, hora = ?, motivo = ?, estado = ?, id_cliente = ?, id_veterinaria = ?, id_mascota = ?
                WHERE id_turno = ?;
                """;
        return jdbcTemplate.update(sql,id_turno);
    }

    public int cancelarTurno(Integer id){
        String sql = """
                UPDATE turno
                SET estado = 'cancelado'
                WHERE id_turno = ?;
                """;
        return jdbcTemplate.update(sql,id);
    }
}
