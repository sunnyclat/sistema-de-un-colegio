package ar.com.eduit.curso.java.utils.swing;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Box {
    
    public static void msg(String text){
        msg(null,text);
    }
    public static void msg(Component cmp,String text){
        JOptionPane.showMessageDialog(cmp, text);
    }
    public static String input(String text){
        return input(null,text);
    }
    public static String input(Component cmp, String text){
        return JOptionPane.showInputDialog(cmp, text);
    }
    public static void error(String error){
        error(null,error);
    }
    public static void error(Component cmp,String error){
        JOptionPane.showMessageDialog(cmp, error, "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    //creamos el cartelito de pregunta para cerciorarse de que el usuario esta seguro de confirmar.
     public static boolean confirm(String question){
        return confirm(null,question);
    }
    public static boolean confirm(Component cmp, String question){
        
        
        JOptionPane jp=null;
        
        if(JOptionPane.showConfirmDialog(cmp, question)==0) 
        {     return true;   //si el usuario presiona un "si", seria 0, entonces me lo devuelve verdadero, sino es falso
     
        }
        
        /*
        else if(JOptionPane.showConfirmDialog(cmp, question)==1 ){
            
                 return false;
            
        }
        */
   return false;
    }
    
    
}