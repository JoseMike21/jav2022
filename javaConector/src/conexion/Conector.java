
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    // 1. Declaracion de las variables que se usaran para la conexion
    private String driver = "com.mysql.jdbc.Driver";    // lleva el driver del conector descargado
    private String host = "127.0.0.1";
    private String user = "root";
    private String pass = "";
    private String bd = "conectorj";
    private String cadena;
    
    
    // 2. declareacion de los objetos para la conexion
    // importaremos el java.sql. Connection y Statement
    Connection connection;
    Statement statement;
   
   
    // 3. Declaracion de los metodos para la conexion
    public void conectar(){
        // concatenamos una ruta de nuestro tipo de conexion: tipo jdbc, mysql: es el tipo de base de datos
        //+ el host que contiene la base de dato 
        this.cadena = "jdbc:mysql://"+this.host+"/" + this.bd;
        try {
            ///RETORNA LA CLASE ASOCIADA PARA QUE SEACTIVE LA CLASE DRIVER
            // el driver manager debe ser del java.sql
            Class.forName(this.driver).newInstance();
             // Para realizar la peticion de la solicitud de la conexion a la base de datos
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
            
        }
        catch(Exception e){
            System.err.println("Error[MC]: " + e.getMessage());
        }
    }
    
    //4. de esta manera se hace la desconexion. (antes de la desconexion
    // debemos probar que se conecta, Run sin que de errores.
     //Metodo para la desconexion
    public void desconectar() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDesc]: "+ e.getMessage());
        }
    }
    
    
    // 5. Crearemos los 2 metodos para que hagan el DML
    //metodo para la realizacion de querys de INSERT, UPDATE, DELETE
    //debe retornar si se hizo o no se hizo la consulta
    // El parametro de la funcion llevara la consulta mysql que deseemos.
    public int consultas_multiples(String query){
        int resultado;
        try { //llamamos a la base de datos
            this.conectar();
           
            // le indicamos al statement que se va a conectar para que haga consultas, creacion de consultas
            this.statement = this.connection.createStatement();
            
            // el executeUpdate permite crear una sonsulta, verifica que la consulta este ien hecha
            resultado = this.statement.executeUpdate(query);
           
        }catch(Exception e){
            System.err.println("Error[MCM]: " + e.getMessage());
            return 0;
        }
        return resultado;
    }
    
    //6. METODO PARA CONSULTAS SELECT
    //captua todos los datos de  la bd, permite manipular
    public ResultSet consultaDatos (String consulta){
        try {
            this.conectar();
            ResultSet resultado = null;
            this.statement = this.connection.createStatement();
            // retorna un resulset, se retorna nulo para saber que existio un error
            // execute quety sirve para extraer informacion con una estructura de filas y columnas
            resultado = this.statement.executeQuery(consulta);
            return resultado;
        } catch (Exception e) {//MCD que es el mensaje para consulta de datos.
            System.err.println("Error[MCD]: " + e.getMessage());
        }
        return null;
    }
}
