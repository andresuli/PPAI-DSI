package ar.edu.utn.frc.cba.sismos.model;

import java.util.Objects;

public class EstadoEvento {
    private String nombre;
    private String descripcion;

    public EstadoEvento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public boolean esEstado(String nombre) {
        return Objects.equals(this.nombre, nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
