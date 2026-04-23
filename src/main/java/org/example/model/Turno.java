package org.example.model;

import java.sql.Date;
import java.sql.Time;

public class Turno {
    private Integer id_turno;
    private Date fecha;
    private Time hora;
    private String motivo;
    private Estado estado;
    private Integer id_cliente;
    private Integer id_veterinaria;
    private Integer id_mascota;

    public Turno(Integer id_turno, Date fecha, Time hora, String motivo, Estado estado, Integer id_cliente, Integer id_veterinaria, Integer id_mascota) {
        this.id_turno = id_turno;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.id_cliente = id_cliente;
        this.id_veterinaria = id_veterinaria;
        this.id_mascota = id_mascota;
    }
    public Turno() {}

    public Integer getId_turno() {
        return id_turno;
    }
    public void setId_turno(Integer id_turno) {
        this.id_turno = id_turno;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Integer getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Integer getId_veterinaria() {
        return id_veterinaria;
    }
    public void setId_veterinaria(Integer id_veterinaria) {
        this.id_veterinaria = id_veterinaria;
    }
    public Integer getId_mascota() {
        return id_mascota;
    }
    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }
}
