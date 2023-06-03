/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author sunnyclat
 */
public class TestConnector {
    
    
    
    //agregamos el exception para que me vaya avisando de los errores
    public static void main(String[] args) throws Exception {
        
        
        Connection conn=ConnectorMySQL.getConnection();
        Statement st=conn.createStatement();  //createstatement me devuelve el objeto statement para la sql
        
        
        //creamos e insertamos la query
        //recordar poner la insercion en el mismo orden
        String query="insert into cursos(materia,profesor,dia,turno) values"
                + "('Java','Miguel','lunes','tarde')";
        
        //cada vez que inserto queda guardado en la tabla.
        
        
        st.execute(query); //ejecuto la sentencia del query en la base de datos
        
        
        
        //creamos e insertamos la query de una forma mas rapida
        ConnectorMySQL.getConnection().createStatement().execute(
        "insert into cursos (materia, profesor,dia,turno) values" +"('PHP','Torres','martes','noche')"
        );
        
        
        conn.close();   //recomendable cerrar la conexion al final y no entre insercion, ya que es algo lento.
        
        
    }
}
