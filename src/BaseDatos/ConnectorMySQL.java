package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectorMySQL {

    
    //ELEGIR EL DRIVER
    
    
    
    private static String driver="com.mysql.jdbc.Driver"; //  driver 5 en adelante.
 
    
 // private static String driver = "com.mysql.cj.jdbc.Driver";  // driver 8 en adelante


    
    //nota: con driver 5.1.4.7 se soluciona el error de bigintenger en remoto y anda en local.
    // 8.0.1.5 no funciona en local pero si en remoto
    
 //si queremos hacer funcionar el testconnector, debemos primeramente incorporar el conector en libraries, ya que aunque lo hayamos 
 //   cargado por services, no funcionara. si tenemos cargado en services el driver y funciona, para que funicone tambien aca
    //tenemos que incorporarlo tambien en libraries.
  
    
   
    

//LOCAL
    
     
    //actualmente en 2021 me anda el driver connector 8026 en local
 
    
    
    private static String url = "jdbc:mysql://localhost:3306/colegio";
    

    private static String user = "root";
    private static String pass = "";

    


   
    

    
    
    //este es el evento para dar de alta la conexion
    private static Connection conn = null; //objeto de conexion unico en todo el sistema

 //no importar con mysqljdbc connection ya que solo hara una conexion de mysql cuando mi intencion es que haga de varios tipos de base de datos
 
        //usamos un patron de diseño singleton ya que queremos un solo objeto en toda la clase el cual maneje las conexiones
    
    
    
    
    
       
    //el constructor del conector es privado.
    private ConnectorMySQL() {
    }

//este es el unico elemento publico en la clase, el cual va a retonar la conexion que voy a crear
    //usamos synchronized para asegurarnos de que sea una sola conexion
    public synchronized static Connection getConnection() {

        
        
       //nos aseguramos que desconecte otra conexion que aparezca con este condicional 
       //si hay una conexion nula, quiere decir que no hay otra y toma la informacion necesaria
       //para hacer la conexion
        if (conn == null) {
          
            
            
            try {
                
                //creamos un objeto class de la ruta donde esta el driver y lo registramos con forname
                Class.forName(driver);                                //no  hace falta que le agregue un new instance,ya que solo necesitamos la clase y ya esta registrada
                conn = DriverManager.getConnection(url, user, pass);     //tomamos la informacion para la conexion ya registrada
           
            
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}