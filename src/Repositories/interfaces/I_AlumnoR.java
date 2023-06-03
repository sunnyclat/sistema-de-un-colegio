/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.interfaces;

import Entities.Alumnos;
import Entities.Curso;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sunnyclat
 */




// Las interfaces son buenas para luego crear las clases implementadas y asi se hara mas facil en las implementaciones con otras base de datos 


//En las clases interfaces se hacen las consultas por codigo, apellido o curso, se hacen en las interfaces.
//Se crean los metodos alta, baja y modificacion que se implementaran en las clases normales.


public interface I_AlumnoR {
    
    void save(Alumnos alumno);       //guarda un alumno
    void remove(Alumnos alumno);   //remueve un alumno
    void update(Alumnos alumno); //actualiza un alumno
    List<Alumnos> getAll();
    
    
    /*
    Alumnos getByCodigo(int id); //si se encuentra el id en la tabla, sino me devuelve nulo
    List<Alumnos> getByApellido(String apellido); //devuelve la lista que contiene ese apellido
    List<Alumnos> getLikeApellido(String apellido); //devuelve el apellido aproximado al que busco
    List<Alumnos> getLikeCurso(Curso curso); //los alumnos aproximados a ese curso.
    List<Alumnos> getLikeCurso(int codigo); //devuelva el codigo de los almunos de ese curso.
    */
    
    
    //busca por id 
    default Alumnos getByCodigo(int codigo){
        
        List<Alumnos> lista=getAll()
                .stream().
                filter(a->a.getCodigo()==codigo)
                .collect(Collectors.toList());
        
        return (lista.isEmpty())? new Alumnos():lista.get(0);
        
        
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //get by busca por el id apellido
    default List<Alumnos> getByApellido(String apellido){
        
        
        return getAll()
                .stream()
                .filter(a->a.getApellido().equalsIgnoreCase(apellido))
                        .collect(Collectors.toList());
        
        
        
    }
            
            
            
            
            
             
            
            
            
            
            
            //get like me busca lo parecido a lo que escriba por ejemplo pe y busco peralta
    default List<Alumnos> getLikeApellido(String apellido){
        
              
           return getAll()
                .stream()
                .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                 .collect(Collectors.toList());  
        
        
        
        
       }
    
    
    
    
   default List<Alumnos> getLikeCurso(Curso curso){
       
       
   //directamente que me devuelva la lista del codigo del proximo metodo
       return getLikeCurso(curso.getCodigo());   
       
       
   }
   
   
   
   
   
   
   
   
   //estamos sobrecargando el metodo anterior siendo por codigo. es opcional
   default List<Alumnos> getLikeCurso(int codigo){
    
        return getAll()
               .stream()
               .filter(a->a.getCurso().getCodigo()==codigo)
               .collect(Collectors.toList());
       
    
    
   }
   
   
   
   
   
   
   
   
   
   
    
}
