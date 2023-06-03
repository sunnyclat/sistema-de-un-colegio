/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.eduit.curso.java.utils.swing;

import java.lang.reflect.Field;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sunnyclat
 */

//ponemos E en generic, lo que significa que la clase sera lo que decida el usuario.



public class Table <E> {
    
    
    public void cargar(JTable tbl,List <E> list){
        //yo quiero que esto cargue cualquier table con cualquier cosa
        // si pusiera static a la clase, no estaria creando un objeto y no funcionarian los generics.
        
        if(tbl==null) 
            return;   //con esto evitamos la nullpointerexception
       
        DefaultTableModel dtm= new DefaultTableModel(); //si la tabla contiene algo
       


        
        tbl.setModel(dtm); //con esto la pongo a la tabla vacia.
        //dtm: default table model.
        
        
        if(list == null  || list.isEmpty())
            return;  //si la lista es nula o la lista esta vacia salgo
       
        E e = list.get(0);   //si la lista tiene informacion, creo un objeto E y obtengo el primer elemento de la lista.
        //estos seran los titulos de las columnas.
        
        Field[] f = e.getClass().getDeclaredFields(); //devuelve un vector de campos del objeto E.
        
        for(Field campo: f) {    //voy recorriendo los campos.
            System.out.println(campo.getName());
        dtm.addColumn(campo.getName());  //pongo el campo como nombre de titulos de cada columna.
        
    }
    
         
        //vector de objetos con tantos elementos como columnas haya.
        
        for(E i:list){  //tengo un vector representando a la fila
            
            
            //creo un registro con la cantidad de campos que haya.
            Object[] registro=new Object[f.length]; //notar que lleva corchete
        
            for(int a=0;a<f.length;a++){
                
               
                
                //substring pide la primer letra con 0,1
                //uppercase lo pone en mayuscula.
                
                String method="get"     //al imprimir, aparecera el get al lado de la palabra que pida
                        +f[a].getName().substring(0,1).toUpperCase() //la primera letra del nombre estara en mayuscula
                        +f[a].getName().substring(1);   //el resto del nombre que quedara en minuscula
                System.out.println(method);
                
             
                
                
                
                
                
                
                
                //aca haremos una programacion dinamica en tiempo de ejecucion
              
                
                //tengo que poner try catch ya que todo esto me puede tirar excepcion.
                try{
                        registro[a]= e   //registro que tendra el valor devuelto de recorrer la fila.
                        .getClass()
                        .getDeclaredMethod(method,null) //pido un metodo declarado con sus parametros de entrada
                        .invoke(i,null); //lo invoco sobre i que es el objeto que recorro en este momento.
                        //al invocarlo tengo una devolucion del valor de la fila. Esto lo cargo en el registro
                
                    
                }catch(Exception ex) {ex.printStackTrace();} //pongo ex porque e ya se lo puse al nombre del objeto E.
                
            
            }
        
            dtm.addRow(registro); //agrego un vector de object.
            
            
            
            

    }
        
      
    
    
    
        
              
    
    
    
    
    
    
    
    
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
