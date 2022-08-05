
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaisDAO implements ConsultaPais{

    @Override
    public boolean insertar(PaisVO p) {
        // el metodo conector dara la interaccion con la base de datos.
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, " 
                    + "capital_pais, poblacion_pais, fecha_ing_pais) "
                    + "VALUES('"+p.getNombrePais()+"', '"+p.getCapitalPais()+"', "
                    +p.getPoblacionPais()+", '"+p.getFechaIngPais()+"')";
              
            // para que haga la consulta con el query que le enviamos
            c.consultas_multiples(query);
        } catch (Exception e) {
            System.err.println("Error[MInsert]: " + e.getMessage());
            c.desconectar();  
            return false; 
        }
        
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PaisVO> consultar() {
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();// yo me conecto
            String query = "SELECT p.id_pais, p.nombre_pais, p.capital_pais, p.poblacion_pais, p.fecha_ing_pais "
                    + "FROM conectorj.pais p";
            // el encargado de obtener esa informacion es el metodo consultardatos, consultarDatos es del tipo Resulset.
            ResultSet rs = c.consultaDatos(query);
            
            // aca llenamos nuestro array.
            // el metodo next interactua y define si el resulset esta vacio, el busca hasta que este vacio.
            while(rs.next()){
                // la infoamacion que trae la consulta va a llenar a los elementos de pvo.
                // pvo tiene los metodos getter y setter
                PaisVO pvo = new PaisVO();
                pvo.setIdPais(rs.getInt(1));
                pvo.setNombrePais(rs.getString(2));
                pvo.setCapitalPais(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4));
                //llenar el arreglo.
                info.add(pvo);
            }
            // cuando el while a llenado todo, yo me desconecto.
            c.desconectar();
                    
                    } catch (Exception e) {
                        System.err.println("Error[MMostrar]: "+ e.getMessage());
                        c.desconectar();
        }
        return info;
    }

    @Override
    public void eliminar(int p) {
        Conector c = new Conector();
       // ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();// yo me conecto
            String query = "DELETE FROM conectorj.pais "
                    + "WHERE id_pais = " + p + ";";
            // el encargado de ejecutar el DELETE.
            c.consultas_multiples(query);
            
           
            // me desconecto.
            c.desconectar();
                    
                    } catch (Exception e) {
                        System.err.println("Error[MEliminar]: "+ e.getMessage());
                        c.desconectar();
        }
        //return info;

        
    }
    
    @Override
    public ArrayList<PaisVO> actualizar(PaisVO p) {
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();// yo me conecto
            String query = "UPDATE conectorj.pais "
                    + "SET nombre_pais = '"+p.getNombrePais()+"', capital_pais = '"+p.getCapitalPais()+"', "
                    + "poblacion_pais ='"+p.getPoblacionPais()+"' "
                    + "WHERE id_pais ="+p.getIdPais();
            // el encargado de obtener esa informacion es el metodo consultardatos, consultarDatos es del tipo Resulset.
            c.consultas_multiples(query);
            
            c.desconectar();
                    
                    } catch (Exception e) {
                        System.err.println("Error[MMostrar]: "+ e.getMessage());
                        c.desconectar();
        }
        return info;
        
    }

}
