/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories.interfaces.jdbc;

import Entities.Curso;
import Enumerados.Dia;
import Enumerados.Turnos;
import Repositories.interfaces.I_CursoR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunnyclat
 */
public class CursoR implements I_CursoR{
    
    
    private Connection conn;
    
    
     public CursoR(Connection conn) {
        this.conn = conn;
    }
    
    
    
    

    @Override
    public void save(Curso curso) {
        
        
        
        if(curso==null) return;   //con esto evitamos la nullpointerexception
        
        
        
        //El problema con esto es que nos podrian hackear con una sql injection
        
        
        
    //    String query="insert into cursos (titulo,profesor,dia,turno)"
     //           + "values ('"+curso.getTitulo()+"','"+curso.getProfesor()
      //          +"','"+curso.getDia()+"','"+curso.getTurno()+"')";
        
        
        /*
        java
        x','martes','noche'); delete from alumnos;--    //esta linea haria pelota la base
        martes
        noches
      */
      
        
      
      //Esto aparecio apartir de java 6
      //preparedStatement es un closeable asi que uso  try catch para manejar los recursos
      
      
      try{
      PreparedStatement ps=conn.prepareStatement(
              "insert into cursos(materia,profesor,dia,turno) values (?,?,?,?)"
      
      ,PreparedStatement.RETURN_GENERATED_KEYS   //constante que vale 1. Lo ponemos asi para que sea mas explicativo.
      
      );
      
      
      //son todos sistemas de seguridad
      ps.setString(1, curso.getMateria() ); //la materia del curso me entra como parametro
      ps.setString(2, curso.getProfesor() );
      ps.setString(3, curso.getDia().toString() );
      ps.setString(4, curso.getTurno().toString() );
      
      ps.execute();  //ejecuta una consulta de insert delete update
      
      ResultSet rs = ps.getGeneratedKeys();  //una especie de select para recuperar el id generado. Devuelve en un conjunto de resultados (varias claves).
      
      
      //si hay registro
      if(rs.next()) curso.setCodigo(rs.getInt(1));  //con "getint 1" obtengo la primer clave entera generada
      
      
      
      
      }catch(Exception e){e.printStackTrace();}
      
      
    }

    @Override
    public void remove(Curso curso) {
  
        
        if(curso==null) return;
        
        try(PreparedStatement ps=conn.prepareCall(
                "delete from cursos where codigo=?"
                
                //debe tener el codigo despues del where
                  //  at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
                
        )){
            
            
        
            
        ps.setInt(1, curso.getCodigo());
        ps.execute();
        
        
        
    }catch(Exception e){e.printStackTrace();}
        
        
    }

    
    //el update es el mas propicio de ser hackeado
    @Override
    public void update(Curso curso) {
        
        
        
      if(curso==null) return;
      
      try(PreparedStatement ps=conn.prepareStatement(
      "update cursos set materia=?, profesor=?, dia=?, turno=?"
              + "where codigo=?"                            //antes estaba id y tiro error
      )){
          ps.setString(1, curso.getMateria());
          ps.setString(2, curso.getProfesor());
          ps.setString(3, curso.getDia().toString());
          ps.setString(4, curso.getTurno().toString());
          ps.setInt(5, curso.getCodigo());
          
          ps.execute();
          
      }catch(Exception e){e.printStackTrace();
      
      
      }
        
        
   }

    
    
    
    
    @Override
    public List<Curso> getAll() {
        
        List<Curso> lista=new ArrayList();
        
        String query="Select * from cursos";
        
        
        //excecutequery me devuelve un resultset con la lista de registros
        //por eso tuve que ponerlo tambien dentro de un try.
        //debo recorrer el resultSet
        
        
        try(ResultSet rs=conn.createStatement().executeQuery(query)){
        
            while(rs.next()){
                
               lista.add(
                       
                       
                       //voy construyendo el objeto curso y lo voy agregando a la lista
               new Curso(
                       rs.getInt("codigo"),
               rs.getString("materia"),
               rs.getString("profesor"),
                       
                       
                       //ya que son tipo enumerado, usamos el metodo getString con valueOf
                       Dia.valueOf(rs.getString("dia") ),
                       Turnos.valueOf(rs.getString("turno") ) ) );
                       
                       
                       
            }
        
        
        
            
            
        }catch(Exception e){e.printStackTrace();}
        
        
        return lista;
        
    }

    
    
    
    //NO VAMOS A USAR ESTOS METODOS, ya que implementamos que todos los metodos en la interface sean  default
    
    /*
    @Override
    public Curso getByCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> getLikeMateriaProfesor(String titulo, String profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> getLikeMateriaProfesorTurno(String titulo, String profesor, Dia dia, Turnos turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
      
      */
      
        
        
       
        
        
        
        
        
        
        
        
        
    }

   
   
    
    
    
    
    
    

