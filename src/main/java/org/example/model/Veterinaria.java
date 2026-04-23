package org.example.model;

public class Veterinaria {
    private Integer id_veterinaria;
    private String nombre;
    private String apellido;
    private Integer matricula;
    private String especialidad;
    private String telefono;
    private String email;

    public Veterinaria(Integer id_veterinaria, String nombre, String apellido, Integer matricula, String especialidad, String telefono, String email) {
        this.id_veterinaria = id_veterinaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
    }
    public Veterinaria() {}

    public Integer getId_veterinaria() {
        return id_veterinaria;
    }
    public void setId_veterinaria(Integer id_veterinaria) {
        this.id_veterinaria = id_veterinaria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
