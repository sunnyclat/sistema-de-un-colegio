package ar.com.eduit.curso.java.utils.swing;
import javax.swing.JTextField;



public class Validator {
    
    
    private JTextField txt;
    public Validator(JTextField txt) {
        this.txt = txt;
    }
    
    
    private boolean setError(String mensaje){
        txt.selectAll();
        txt.requestFocus();
        Box.error(txt,mensaje);
        return false;
    }
    
    
    public boolean length(int length){
        if(txt.getText().length()==length) return true;
        return setError("Debe tener "+length+" caracteres");
    }
    
    
    public boolean length(int min,int max){
        if(txt.getText().length()>=min && txt.getText().length()<=max) return true;
        return setError("Debe tener entre "+min+" y "+max);
    }
    
    
    public boolean isInteger(){
        try {
            Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            return setError("El texto debe ser un número entero.");
        }
    }
    
    
    public boolean isInteger(int min,int max){
        if(!isInteger()) return false;
        int nro=Integer.parseInt(txt.getText());
        if(nro>=min && nro<=max) return true;
        return setError("Debe ser un número entero entre "+min+" y "+max);
    }
}