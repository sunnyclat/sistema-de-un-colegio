/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.interfaces;

import Entities.Curso;
import Enumerados.Dia;
import Enumerados.Turnos;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sunnyclat
 */
public interface I_CursoR {
    
    
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    
    List<Curso> getAll(); //devuelvo la coleccion total. No es muy eficiente en memoria esto pero a veces no queda otra
    
    
    //si quiero por ejemplo crear una implementacion para jdbc, ya el metodo getall tendra todo lo necesario, ademas de usar el save remove y update.
    
    
    //voy a escribir codigo java usando api stream para ir filtrando lo que necesite como metodos default. Esto ayuda para implementar en otra tecnlogia mas facil.
    //por ejemplo hoy en dia se usa factura electronica, usaria el getall para hacer las tareas y no usar lo otro que no necesitaria la factura.
    //ademas no necesitare estar obligado a implementarlo en CursoR
    
    default Curso getByCodigo(int codigo){
        
        List<Curso>lista=getAll()
                .stream()
                .filter(c->c.getCodigo()==codigo)
                .collect(Collectors.toList());
        
        
        //usamos un operador ternario para el caso de que no encuentre un codigo pedido y me devuelva
        // un objeto de curso vacio evitando null pointer exception; por lo que de esta manera, nos devolveria el primer elemento pero vacio
        
        return(lista.isEmpty()) ? new Curso(): lista.get(0);  //con esto le quitamos la dependencia con sql
        
        
        
        
    }
    
    
    default List<Curso> getLikeMateriaProfesor(String materia, String profesor){
        
        
        //vamos a usar getAll en cada uno de los metodos default
        
        //usamos una api stream para ir filtrando la informacion y nos ira devolviendo un stream, pero yo necesito un list,
        // y para obtenerlo, al final uso .collect para recibir un list
        return getAll()
                .stream()
                .filter(c->c.getMateria().toLowerCase().contains(materia.toLowerCase())
                && c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
        .collect(Collectors.toList());
    }
    
    
       default List<Curso> getLikeMateriaOProfesor(String materia, String profesor){
        
        
        //vamos a usar getAll en cada uno de los metodos default
        
        //usamos una api stream para ir filtrando la informacion y nos ira devolviendo un stream, pero yo necesito un list,
        // y para obtenerlo, al final uso .collect para recibir un list
        return getAll()
                .stream()
                .filter(c->c.getMateria().toLowerCase().contains(materia.toLowerCase())
                || c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
        .collect(Collectors.toList());
    }
    
    default List<Curso> getLikeMateriaProfesorTurno(String materia,String profesor, Dia dia, Turnos turno){
        
        return getAll()
                .stream()
                .filter(c->c.getMateria().toLowerCase().contains(materia.toLowerCase()) //el titulo pasado a minuscula pase a titulo.
                && c.getProfesor().toLowerCase().contains(profesor.toLowerCase())
                && c.getDia()==dia && c.getTurno()==turno)
        .collect(Collectors.toList());
        
        
    }
    
    
    
}
