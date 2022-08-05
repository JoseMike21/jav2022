
package conectorcompleto;

import conexion.Conector;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

public class ConectorCompleto {
    public static void main(String[] args) {
        //1. llamamos al metodo conector, creando un objeto del tipo Conector
        //esto para hacer la prueba de conexion, lugo la comentamos
        //Conector c = new Conector();
        
 // agregamos las vistas
// agregamos el controlador
// inicializamos la pantalla del menu
// el relative null, para que aparezca en el centro la ventana
// el setResizable para que no cambie de tamanho
              
    //Vistas
        FrmMenu fm = new FrmMenu();
        FrmInsertar fi = new FrmInsertar();
        FrmMostrar fmos = new FrmMostrar();  
        FrmEliminar felim = new FrmEliminar();
        FrmActualizar fa = new FrmActualizar();
     
        
        //modelo
        PaisDAO pdao = new PaisDAO();
        PaisVO pvo = new PaisVO();        
        
    // controladores, si no defino los controladores, no puedo interactuar con ningun componente que
    //tenga mi ventana, porque nunca se inicializan.
        ControladorMenu cm = new ControladorMenu(fm, fi, fmos, felim, fa);

        ControladorInsertar ci = new ControladorInsertar(fi, pvo, pdao);
        ControladorMostar cmos = new ControladorMostar(fmos, pvo, pdao);
        ControladorEliminar celim = new ControladorEliminar(felim, pvo, pdao);
        ControladorActualizar ca = new ControladorActualizar(fa, pvo, pdao);
 
        //configuracion de pantalla menu
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);

    }
    
   
    
}
