/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.interfaces.jdbc;

import Entities.Alumnos;
import Entities.Curso;
import Repositories.interfaces.I_AlumnoR;
//import com.mysql.jdbc.PreparedStatement;  //al poner de mysql no funciona al buscar cosas de mysql
import java.sql.Connection;
import java.sql.PreparedStatement; //este es el que va 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunnyclat
 */


//implementacion de alumno de la interface alumno


//En las clases normales se implementan y desarrollan los metodos de alta,baja y modificacion.
//Se hace la consulta getAll (general que me traiga todos los codigos de la tabla alumnos)

public class AlumnoR implements I_AlumnoR{

    private Connection conn;

    public AlumnoR(Connection conn) {
        this.conn = conn;
    }
    
    
    
    
    
    
    
    
    @Override
    public void save(Alumnos alumno) {
        
        
        
        //poniendo return evitamos un error de null pointer exception
     if(alumno==null) return;  
     
     String query="insert into alumnos(nombre,apellido,edad,codigoCurso) values (?,?,?,?)";
     
     
     //recordar siempre importar la utilidad de sql no mysql
     try(PreparedStatement ps=conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)){
         
         //ponemos todos los parametros del objeto alumno
         ps.setString(1, alumno.getNombre());     
         ps.setString(2, alumno.getApellido());
         ps.setInt(3, alumno.getEdad());
         ps.setInt(4, alumno.getCurso().getCodigo());
         ps.execute();
         ResultSet rs= ps.getGeneratedKeys(); //le asignamos la ID
         
         
         if(rs.next()) alumno.setCodigo(rs.getInt(1));  //pedimos el entero generado, el generated key o ID asignado
         
         
         
         
         
         
         
     }catch(Exception e) {e.printStackTrace();}
     
     
     
     
     
     
     
     
     
     
     
     
    }

    @Override
    public void remove(Alumnos alumno) {
        
        
       if(alumno==null) return;
       
       
     // String query="delete from alumnos where id=?";
    
     

//puse codigo en vez de id y dejo de tirar el error de abajo.
     

    //  at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)

      String query="delete from alumnos where codigo=?";
      

     
      
      
      try(PreparedStatement ps=conn.prepareStatement(query)){
          
          
          ps.setInt(1,alumno.getCodigo());
          ps.execute();
          
      }catch(Exception e) {e.printStackTrace();}
       
       
       
    }

    @Override
    public void update(Alumnos alumno) {
      if(alumno==null) return;
      
      String query ="update alumnos set nombre=?,apellido=?,edad=?,codigoCurso=? where codigo=?";
      
  
      // deberia ser codigoCurso y no CodigoCurso, pero funciona
      
      try(PreparedStatement ps=conn.prepareStatement(query)){
          
          ps.setString(1, alumno.getNombre());
          ps.setString(2, alumno.getApellido());
          ps.setInt(3, alumno.getEdad());
          ps.setInt(4, alumno.getCurso().getCodigo());
          ps.setInt(5, alumno.getCodigo());
          ps.execute();
          
          
          
          
          
          
      }catch(Exception e) {e.printStackTrace();}
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    }

    
    
    @Override
    public List<Alumnos> getAll() {

        
        CursoR cr=new CursoR(conn);
        
        
        
        List<Alumnos>lista=new ArrayList();
        String query="select * from alumnos";
        
        
        try(ResultSet rs=conn.createStatement().executeQuery(query)){
            
            
            while(rs.next()){
                
                lista.add(
                        
                new Alumnos(
                        
                rs.getInt("codigo"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getInt("edad"),
                cr.getByCodigo(rs.getInt("codigoCurso"))        
                )
                
                );  
            }
            
            
            
            
            
            
            
            
            
            
            
        }catch(Exception e) {e.printStackTrace();}
        
        
        return lista;
        
        
        
        
        
        
        
        
        
        
        
        
    }
/*
    @Override
    public Alumnos getByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Si no lo comento tira este error al recurrir al getbycodigo
        // Exception in thread "AWT-EventQueue-0" java.lang.UnsupportedOperationException: Not supported yet.
    
    
*/
    
    
    
    
    
    
    /*
    @Override
    public List<Alumnos> getByApellido(String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumnos> getLikeApellido(String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumnos> getLikeCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumnos> getLikeCurso(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
