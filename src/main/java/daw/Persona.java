/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author aiman
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private LocalDate fecha_nacimiento; 
    private boolean jubilado;
    private String ciudad;

    public Persona(int id, String nombre, String apellido, String email, String genero, LocalDate fecha_nacimiento, boolean jubilado, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.jubilado = jubilado;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int devolverEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fecha_nacimiento, ahora);
        return periodo.getYears();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", email=").append(email);
        sb.append(", genero=").append(genero);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", jubilado=").append(jubilado);
        sb.append(", ciudad=").append(ciudad);
        sb.append('}');
        return sb.toString();
    }
}
