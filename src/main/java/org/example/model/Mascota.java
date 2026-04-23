package org.example.model;

import java.math.BigDecimal;

public class Mascota {
    private Integer id_mascota;
    private String nombre;
    private String raza;
    private Integer edad;
    private BigDecimal peso;
    private Integer id_cliente;
    private Boolean activo;

    public Mascota(Integer id_mascota, String nombre, String raza, Integer edad, BigDecimal peso, Integer id_cliente, Boolean activo) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.id_cliente = id_cliente;
        this.activo = activo;
    }
    public Mascota() {}

    public Integer getId_mascota() {
        return id_mascota;
    }
    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public BigDecimal getPeso() {
        return peso;
    }
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public Integer getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
