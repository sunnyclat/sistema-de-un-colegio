/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import BaseDatos.ConnectorMySQL;
import Entities.Alumnos;
import Entities.Curso;
import Enumerados.Dia;
import Enumerados.Turnos;
import Repositories.interfaces.I_CursoR;
import Repositories.interfaces.jdbc.AlumnoR;
import Repositories.interfaces.jdbc.CursoR;

/**
 *
 * @author sunnyclat
 */


//aplicacion de ejemplo para probar los repositories antes de incrustarlo en una interfaz grafica

public class TestRepositories {

    public static void main(String[] args) {

        
        //CON CURSO
        
        I_CursoR cr = new CursoR(ConnectorMySQL.getConnection());
  
        

        
        
        
        //TESTEAMOS EL METODO SAVE
        
        
        Curso curso = new Curso("NodeJS", "Hector", Dia.viernes, Turnos.noche);
        cr.save(curso);
        System.out.println(curso); //cada vez que ejecuto se genera una nueva id
        
      
        
        
        
        //TESTEAMOS EL METODO GETALL (la lista completa)
        
        
        
        
    //   cr.getAll().forEach(System.out::println);
        
        
        
        
      //TESTEAMOS EL METODO REMOVE 
      
      
      
      
  //      cr.remove(cr.getByCodigo(8));  //me borra el curso 8.
        
        
        
        //TESTEAMOS EL METODO UPDATE
    
        /*
        Curso cursoX= cr.getByCodigo(1);
        cursoX.setMateria("JAVASCRIPT");
        cursoX.setProfesor("picolo");
        cr.update(cursoX);
        
        */
        
        
        
        
        
        //TESTEAMOS EL METODO GETBYCODIGO
        
        /*
        Curso cursoX=cr.getByCodigo(1);
        
        cursoX.setTitulo("HTML");
        
        cursoX.setProfesor("soto");
        
        cr.update(cursoX);
*/


        
        

       //TESTEAMOS EL METODO GETLIKE (recordar que estaremos usando un getAll dentro)
       
   
       
       /*
       cr.getLikeMateriaProfesor("java", "").forEach(System.out::println);
   */
   
   
   
   //CON ALUMNOS
   
     AlumnoR ar=new AlumnoR(ConnectorMySQL.getConnection());
   
   


//TESTEAMOS EL METODO SAVE
   
   
      
   
   // aca estariamos poniendo el codigo de un curso existente, al cual le agregariamos dicho alumno

        
        
     /*      
   Alumnos alumno= new Alumnos("Pañuelo","Molinari",40,cr.getByCodigo(3));
   ar.save(alumno);
  System.out.println(alumno);
   
   */
   
   
   //TESTEAMOS EL METODO GETBYCODIGO
 
   /*
  Alumnos a=ar.getByCodigo(3);
  
  a.setNombre("veronica");
  a.setApellido("Maza");
  ar.update(a);
 */ 
  
  
  
  //TESETAMOS EL METODO GETALL
  
  
  
  
  
 //  ar.getAll().forEach(System.out::println);
   

  
  //TESTEAMOS EL METODO GETLIKEAPELLIDO
  
 // ar.getLikeApellido("do").forEach(System.out::println);
  
  
  
 
 //TESTEAMOS EL METODO REMOVE
 
// ar.remove(ar.getByCodigo(1));
 
 


//TESTEAMOS EL METODO UPDATE



/*
Alumnos a= ar.getByCodigo(5);
 
  

a.setNombre("estornudo");

ar.update(a);

*/




    }
}
