
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;
// 1. implementamos el action lister y sus clases abstractas
public class ControladorMenu implements ActionListener{
  // 2. definimos las pantallas que vn a interactuar con el controlador
    FrmMenu vMenu  = new FrmMenu();
    FrmInsertar vInsertar = new FrmInsertar();
    FrmMostrar vMostrar = new FrmMostrar();
    FrmEliminar vEliminar = new FrmEliminar();
    FrmActualizar vActualizar = new FrmActualizar();
    
    
    //3. creamos el controlador con los objetos que manejara
    //y agregamos los botones que tendran interacion.
    public ControladorMenu(FrmMenu vMenu,FrmInsertar vInsertar, FrmMostrar vMostrar, FrmEliminar vEliminar, FrmActualizar vActualizar){
        this.vMenu = vMenu;
        this.vInsertar = vInsertar;
        this.vMostrar = vMostrar;
        this.vEliminar = vEliminar;
        this.vActualizar = vActualizar;
        
        vMenu.btnInsertar.addActionListener(this);
       vMenu.btnMostrar.addActionListener(this);
       vMenu.btnEliminar.addActionListener(this);
       vMenu.btnActualizar.addActionListener(this);
    }

//    public ControladorMenu(FrmMenu fm, FrmInsertar fi, FrmMostrar fmos, FrmEliminar felim) {
        
  //  }
    
    // 1, clase abstracta del action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        // para cuando active insertar
        if(e.getSource()== this.vMenu.btnInsertar){
            this.vInsertar.setVisible(true);
            this.vInsertar.setLocationRelativeTo(vMenu);
        }
        //para cuando active mostrar
        if(e.getSource()== this.vMenu.btnMostrar){
            this.vMostrar.setVisible(true);
            this.vMostrar.setLocationRelativeTo(vMenu);
        }
        
        if(e.getSource()== this.vMenu.btnEliminar){
            this.vEliminar.setVisible(true);
            this.vEliminar.setLocationRelativeTo(vMenu);
        }
        
        if(e.getSource()== this.vMenu.btnActualizar){
            this.vActualizar.setVisible(true);
            this.vActualizar.setLocationRelativeTo(vMenu);
        }
    }
    
}
