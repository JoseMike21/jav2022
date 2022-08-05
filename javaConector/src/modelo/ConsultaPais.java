
package modelo;

import java.util.ArrayList;

public interface ConsultaPais {
    // nesecitamos pasarle al metodo INSERTAR el parametro tabla.
    
    // Metodo abstracto, con el parametro de la tabla
    public boolean insertar (PaisVO p);
    
    
    // crearemos un metodo del tipo array que lleve como parametro
    // toods los elementos de la tabla, los cuales estan en PAISVO.
    // por cada tabla utilizaremos un array.
    public ArrayList<PaisVO> consultar();
    public void eliminar (int p);
    public ArrayList<PaisVO>  actualizar(PaisVO p);
    
}
