/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author sunnyclat
 */

//entidad de persistencia (tabla alumnos)


public class Alumnos {
    
    
    private int codigo;
    private String nombre;
    private String apellido;
    private int edad;
    private Curso curso;
    
    
    
  //constructor vacio (hereda su estado por setters)
    public Alumnos() {
    }

    
    
    
       
    //constructor sin el codigo id (ya que nos pedira desde una interfaz grafica solo los campos menos la id)
    public Alumnos(String nombre, String apellido, int edad, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }

    
    
    
        //constructor parametrico total (contiene el codigo id, ya que trae el objeto desde la base de datos con sus campos)
    public Alumnos(int codigo, String nombre, String apellido, int edad, Curso curso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }

    
    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", curso=" + curso + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
