/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Enumerados.Dia;
import Enumerados.Turnos;

/**
 *
 * @author sunnyclat
 */


//entidad de persistencia (tabla cursos)

public class Curso {
    
    private int codigo;
    private String materia;
    private String profesor;
    private Dia dia;
    private Turnos turno;

    
    //constructor vacio (hereda su estado por setters)
    public Curso() {
    }

    
    
    //constructor sin el codigo id (ya que nos pedira desde una interfaz grafica solo los campos menos la id)
    public Curso(String materia, String profesor, Dia dia, Turnos turno) {
        this.materia = materia;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    
    //constructor parametrico total (contiene el codigo id, ya que trae el objeto desde la base de datos con sus campos)
    public Curso(int codigo, String materia, String profesor, Dia dia, Turnos turno) {
        this.codigo = codigo;
        this.materia = materia;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    public Turnos getTurno() {
        return turno;
    }

    public void setTurno(Turnos turno) {
        this.turno = turno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
      //  return  codigo + ", " + materia + ", " +  profesor + ", " + dia + ", " + ", " +  turno;
      
       return   materia + ", " +  profesor + ", " + dia + ", " + turno;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
